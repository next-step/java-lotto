package lotto.ui.input.info;

import lotto.core.Ball;
import lotto.core.SixBall;
import lotto.core.round.Round;
import lotto.ui.input.GameInput;
import lotto.ui.input.info.request.WinningBonusBallRequest;
import lotto.ui.input.info.request.WinningSixBallsRequest;

public class RoundInputData implements InputData<Round> {
    private final GameInput gameInput;
    private final WinningSixBallsRequest winningSixBalls;
    private final WinningBonusBallRequest winningBonusBall;

    public RoundInputData(GameInput gameInput) {
        this.gameInput = gameInput;

        this.winningSixBalls = new WinningSixBallsRequest(gameInput);
        this.winningBonusBall = new WinningBonusBallRequest(gameInput);
    }

    @Override
    public Round input() {
        try {
            SixBall sixBall = winningSixBalls.request();
            Ball bonusBaall = winningBonusBall.request();

            return new Round(sixBall, bonusBaall);
        } catch (Exception e) {
            gameInput.alertWarn(e.getMessage());
            return input();
        }
    }

}
