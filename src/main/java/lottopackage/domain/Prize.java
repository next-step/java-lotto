package lottopackage.domain;

import java.util.*;

public enum Prize {
    FIRST(1, 6, false,2_000_000_000),
    //SECOND(2, 6, true, 30000000),
    THIRD(3, 5, false, 1_500_000),
    FOURTH(4, 4, false, 50_000),
    FIFTH(5, 3, false, 5_000),
    SIXTH(6, 0, false, 0);

    /* Member Variable */
    private final int prizeNumber;
    private final int ball;
    private final boolean bonusBall;
    private final int winningAmount;

    /* Constructor */
    Prize(int prizeNumber, int ball, boolean bonusBall, int winningAmount) {
        this.prizeNumber = prizeNumber;
        this.bonusBall = bonusBall;
        this.ball = ball;
        this.winningAmount = winningAmount;
    }

    /* Getter */
    public int getBall() {
        return ball;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    /* Method */
    public static Prize isPrize(Set<Integer> lotto, Set<Integer> winningNumber) {
        Set<Integer> lottoForPrizeCheck = new HashSet<>(lotto);
        lottoForPrizeCheck.removeAll(winningNumber);
        return Arrays.stream(Prize.values()).filter((prize) -> prize.ball == (6 - lottoForPrizeCheck.size())).findFirst().orElse(Prize.SIXTH);
    }
}
