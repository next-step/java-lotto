package lotto.domain;

import lotto.message.ErrorMessage;

public class WinningLottoBalls {
    private final LottoBalls winningBalls;
    private final LottoNumber bonusBall;

    public WinningLottoBalls(LottoBalls winningBalls, LottoNumber bonusBall) {
        this.winningBalls = winningBalls;
        this.bonusBall = bonusBall;
        validate();
    }

    private void validate() {
        if (winningBalls == null) {
            throw new RuntimeException(ErrorMessage.INVALID_WINNING_BALL);
        }
        if (bonusBall == null) {
            throw new RuntimeException(ErrorMessage.INVALID_BONUS_BALL);
        }
        if(winningBalls.contains(bonusBall)){
            throw new RuntimeException(ErrorMessage.INVALID_BONUS_BALL);
        }
    }

    public LottoBalls getWinningBalls() {
        return winningBalls;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
