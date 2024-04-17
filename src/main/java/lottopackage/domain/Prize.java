package lottopackage.domain;

import lottopackage.vo.LottoBalls;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    SIXTH(0, false, 0);

    private final int ball;
    private final boolean bonusBall;
    private final int winningAmount;

    Prize(int ball, boolean bonusBall, int winningAmount) {
        this.ball = ball;
        this.bonusBall = bonusBall;
        this.winningAmount = winningAmount;
    }

    public int getBall() {
        return ball;
    }

    public boolean getBonusBall() {
        return bonusBall;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static Prize checkPrize(LottoBalls lotto, WinningNumberAndBonusBall winningNumberAndBonusBall) {
        return WinningNumberAndBonusBall.checkPrize(lotto, winningNumberAndBonusBall);
    }
}
