package gameresult;

import java.time.Duration;
import java.time.ZonedDateTime;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract sealed class GameResult permits OnePlayerGameResult, TwoPlayerGameResult {
    @NonNull private Duration duration;
    @NonNull private ZonedDateTime created;
}
