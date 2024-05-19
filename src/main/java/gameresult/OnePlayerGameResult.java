package gameresult;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper=true)
public final class OnePlayerGameResult extends GameResult {
    @NonNull private String playerName;
    private boolean solved;
    private int numberOfMoves;
}