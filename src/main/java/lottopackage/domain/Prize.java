package lottopackage.domain;

import java.util.ArrayList;
import java.util.List;

public enum Prize {
    FIRST(1, 6, false,2000000000),
    //SECOND(2, 6, true, 30000000),
    THIRD(3, 5, false, 1500000),
    FOURTH(4, 4, false, 50000),
    FIFTH(5, 3, false, 5000),
    SIXTH(6, 0, false, 0);

    private final int prizeNumber;
    private final int ball;
    private final boolean bonusBall;
    private final int winningAmount;

    Prize(int prizeNumber, int ball, boolean bonusBall, int winningAmount) {
        this.prizeNumber = prizeNumber;
        this.bonusBall = bonusBall;
        this.ball = ball;
        this.winningAmount = winningAmount;
    }

    public int getBall() {
        return ball;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int getPrizeNumber() {
        return prizeNumber;
    }

    public static Prize isPrize(List<Integer> lotto, List<Integer> winningNumber) {
        List<Integer> lottoForPrizeCheck = new ArrayList<>(lotto);
        lottoForPrizeCheck.removeAll(winningNumber);
        if (lottoForPrizeCheck.isEmpty()) {
            return Prize.FIRST;
        }
        if (lottoForPrizeCheck.size() == 1) {
            return Prize.THIRD;
        }
        if (lottoForPrizeCheck.size() == 2) {
            return Prize.FOURTH;
        }
        if (lottoForPrizeCheck.size() == 3) {
            return Prize.FIFTH;
        }
        return Prize.SIXTH;
    }
}
