package gameresult.manager.json;

import java.nio.file.Path;

import lombok.NonNull;

import gameresult.OnePlayerGameResult;
import gameresult.manager.OnePlayerGameResultManager;

public class JsonOnePlayerGameResultManager extends JsonGameResultManager<OnePlayerGameResult> implements OnePlayerGameResultManager {

    public JsonOnePlayerGameResultManager(@NonNull Path filePath) {
        super(OnePlayerGameResult.class, filePath);
    }

}
