package gameresult;

import lombok.*;
import lombok.experimental.SuperBuilder;

import game.State;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper=true)
public final class TwoPlayerGameResult extends GameResult {
    private String player1Name;
    private String player2Name;
    private State.Status status;
    private int numberOfTurns;
}
