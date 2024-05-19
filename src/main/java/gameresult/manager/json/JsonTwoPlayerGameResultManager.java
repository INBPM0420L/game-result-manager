package gameresult.manager.json;

import java.nio.file.Path;

import lombok.NonNull;

import gameresult.TwoPlayerGameResult;
import gameresult.manager.TwoPlayerGameResultManager;

public class JsonTwoPlayerGameResultManager extends JsonGameResultManager<TwoPlayerGameResult> implements TwoPlayerGameResultManager {

    public JsonTwoPlayerGameResultManager(@NonNull Path filePath) {
        super(TwoPlayerGameResult.class, filePath);
    }

}
