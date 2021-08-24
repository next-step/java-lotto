package Lotto.Ticket;

public enum Prize {
    FIRST(2000000000),
    SECOND(1500000),
    THIRD(50000),
    FOURTH(5000),
    LOSER(0);

    public static final int WINNING_COUNTS_6 = 6;
    public static final int WINNING_COUNTS_5 = 5;
    public static final int WINNING_COUNTS_4 = 4;
    public static final int WINNING_COUNTS_3 = 3;
    private final int prizeMoney;

    Prize(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public static Prize calculatePrizeMoney(int winningNumberCount) {
        if (winningNumberCount == WINNING_COUNTS_6) {
            return FIRST;
        }

        if (winningNumberCount == WINNING_COUNTS_5) {
            return SECOND;
        }

        if (winningNumberCount == WINNING_COUNTS_4) {
            return THIRD;
        }

        if (winningNumberCount == WINNING_COUNTS_3) {
            return FOURTH;
        }

        return LOSER;
    }

    public int getValue() {
        return prizeMoney;
    }
}
