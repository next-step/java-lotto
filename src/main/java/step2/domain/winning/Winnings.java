package step2.domain.winning;

import step2.domain.Amount;
import step2.domain.Rank;

public class Winnings {
    private static final Rank FIRST_RANK = new Rank(6);
    private static final Rank SECOND_RANK = new Rank(5);
    private static final Rank THIRD_RANK = new Rank(4);
    private static final Rank FORTH_RANK = new Rank(3);

    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int forth = 0;
    private int winnings = 0;

    private void accumulate(int winningAmount) {
        this.winnings += winningAmount;
    }

    public void inquiry(Rank rank) {
        if (rank.equals(FIRST_RANK)) {
            accumulate(WinningAmount.FIRST.getAmount());
            this.first++;
            return;
        }

        if (rank.equals(SECOND_RANK)) {
            accumulate(WinningAmount.SECOND.getAmount());
            this.second++;
            return;
        }

        if (rank.equals(THIRD_RANK)) {
            accumulate(WinningAmount.THIRD.getAmount());
            this.third++;
            return;
        }

        if (rank.equals(FORTH_RANK)) {
            accumulate(WinningAmount.FORTH.getAmount());
            this.forth++;
            return;
        }
    }

    public double rate(Amount amount) {
        double rate = (double) winnings / amount.getAmount();
        return Math.round(rate * 100) / 100.0;
    }


    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getForth() {
        return forth;
    }
}
