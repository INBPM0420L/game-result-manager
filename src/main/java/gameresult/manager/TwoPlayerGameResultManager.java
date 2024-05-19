package gameresult.manager;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

import lombok.AllArgsConstructor;
import lombok.Data;

import game.State.Status;
import gameresult.TwoPlayerGameResult;

public interface TwoPlayerGameResultManager extends GameResultManager<TwoPlayerGameResult> {

    default List<Wins> getPlayersWithMostWins(int limit) throws IOException {
        Map<String, Long> winsByPlayerName = getAll().stream()
                .filter(result -> result.getStatus() == Status.PLAYER_1_WINS || result.getStatus() == Status.PLAYER_2_WINS)
                .map(result -> switch (result.getStatus()) {
                    case PLAYER_1_WINS -> result.getPlayer1Name();
                    case PLAYER_2_WINS -> result.getPlayer2Name();
                    default -> throw new AssertionError();
                })
                .collect(groupingBy(Function.identity(), counting()));
        return winsByPlayerName.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(entry -> new Wins(entry.getKey(), entry.getValue()))
                .toList();
    }

    @AllArgsConstructor
    @Data
    final class Wins {
        private String playerName;
        private long numberOfWins;
    }

}
