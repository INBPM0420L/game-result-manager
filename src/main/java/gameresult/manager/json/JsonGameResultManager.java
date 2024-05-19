package gameresult.manager.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

import gameresult.GameResult;
import gameresult.manager.GameResultManager;
import util.JacksonHelper;

public abstract class JsonGameResultManager<T extends GameResult> implements GameResultManager<T> {

    private final Class<T> gameResultClass;
    private final Path filePath;

    public JsonGameResultManager(Class<T> gameResultClass, @NonNull Path filePath) {
        this.gameResultClass = gameResultClass;
        this.filePath = filePath;
    }

    @Override
    public List<T> add(@NonNull T result) throws IOException {
        var results = getAll();
        results.add(result);
        try (var out = Files.newOutputStream(filePath)) {
            JacksonHelper.writeList(out, results);
        }
        return results;
    }

    public List<T> getAll() throws IOException {
        if (!Files.exists(filePath)) {
            return new ArrayList<>();
        }
        try (var in = Files.newInputStream(filePath)) {
            return JacksonHelper.readList(in, gameResultClass);
        }
    }

}
