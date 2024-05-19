package gameresult.manager;

import java.io.IOException;
import java.util.List;

import gameresult.GameResult;

public interface GameResultManager<T extends GameResult> {

    List<T> add(T result) throws IOException;

    List<T> getAll() throws IOException;

}
