package gameresult.manager;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import gameresult.GameResult;
import gameresult.OnePlayerGameResult;

public interface OnePlayerGameResultManager extends GameResultManager<OnePlayerGameResult> {

    private List<OnePlayerGameResult> getBestByComparator(Comparator<OnePlayerGameResult> comparator, int limit) throws IOException {
        return getAll()
                .stream()
                .filter(OnePlayerGameResult::isSolved)
                .sorted(comparator)
                .limit(limit)
                .toList();
    }
    default List<OnePlayerGameResult> getBestByNumberOfMoves(int limit) throws IOException {
        return getBestByComparator(Comparator.comparingInt(OnePlayerGameResult::getNumberOfMoves), limit);
    }

    default List<OnePlayerGameResult> getBestByDuration(int limit) throws IOException {
        return getBestByComparator(Comparator.comparing(GameResult::getDuration), limit);
    }

}
