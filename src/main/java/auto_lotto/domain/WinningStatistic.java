package auto_lotto.domain;

public enum WinningStatistic {
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    SIX_MATCHES(6, 2_000_000_000);

    private final int matches;
    private final long prizeAmountWon;

    WinningStatistic(int matches, long prizeAmountWon) {
        this.matches = matches;
        this.prizeAmountWon = prizeAmountWon;
    }

    public int getMatches() {
        return matches;
    }

    public static WinningStatistic getByMatches(int matches) {
        for (WinningStatistic statistic : values()) {
            if (statistic.getMatches() == matches) {
                return statistic;
            }
        }
        throw new IllegalArgumentException("Invalid number of matches");
    }
}
