package gameresult.manager;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

import lombok.AllArgsConstructor;
import lombok.Data;

import gameresult.TwoPlayerGameResult;

public interface TwoPlayerGameResultManager extends GameResultManager<TwoPlayerGameResult> {

    default List<Wins> getPlayersWithMostWins(int limit) throws IOException {
        return getAll().stream()
                .map(result -> switch (result.getStatus()) {
                    case PLAYER_1_WINS -> Optional.of(result.getPlayer1Name());
                    case PLAYER_2_WINS -> Optional.of(result.getPlayer2Name());
                    default -> Optional.<String>empty();
                })
                .flatMap(Optional::stream)
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
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
