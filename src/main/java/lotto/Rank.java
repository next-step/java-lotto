package lotto;

public enum Rank {
    FIRST_PLACE(6, "6개 일치 (2000000000원)", 2_000_000_000),
    SECOND_PLACE(5, "5개 일치 (1500000원)", 1_500_000),
    THIRD_PLACE(4, "4개 일치 (50000원)", 50_000),
    FOURTH_PLACE(3, "3개 일치 (5000원)", 5_000),
    FAILURE(0, "0", 0);

    private static final int WINNING_MIN_COUNT = 3;

    private final int countOfMatch;
    private final int winningMoney;
    private final String displayText;

    Rank(int countOfMatch, String displayText, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.displayText = displayText;
    }
}