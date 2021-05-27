package lotto.ui.input.info;

import lotto.core.SixBall;
import lotto.core.round.Round;
import lotto.ui.input.GameInput;
import lotto.ui.input.Input;
import lotto.ui.input.info.request.WinningBonusRequest;
import lotto.ui.input.info.request.WinningSixBallsRequest;

public class RoundInputData implements InputData<Round> {
    private final GameInput gameInput;
    private final WinningSixBallsRequest winningSixBalls;
    private final WinningBonusRequest winningBonus;

    public RoundInputData(Input input) {
        this.gameInput = (GameInput) input;

        this.winningSixBalls = new WinningSixBallsRequest(gameInput);
        this.winningBonus = new WinningBonusRequest(gameInput);
    }

    @Override
    public Round input() {
        try {
            SixBall sixBall = winningSixBalls.request();
            int bonus = winningBonus.request();

            return new Round(sixBall, bonus);
        } catch (Exception e) {
            gameInput.alertWarn(e.getMessage());
            return input();
        }
    }

}
