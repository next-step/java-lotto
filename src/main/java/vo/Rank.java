package vo;

public enum Rank {
    FIRST_PLACE(6, "6개 일치 (2000000000원)", 2_000_000_000),
    SECOND_PLACE(6, "5개 일치, 보너스 볼 일치(30000000원)", 30_000_000),
    THIRD_PLACE(5, "5개 일치 (1500000원)", 1_500_000),
    FOURTH_PLACE(4, "4개 일치 (50000원)", 50_000),
    FIFTH_PLACE(3, "3개 일치 (5000원)", 5_000),
    FAILURE(0, "0", 0);

    private static final int WINNING_MIN_COUNT = 3;
    private static final int WINNING_CORRECT_5 = 5;

    private final int countOfMatch;
    private final int winningMoney;
    private final String displayText;

    Rank(int countOfMatch, String displayText, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.displayText = displayText;
    }

    public static Rank valueOf(int countOfMatch, boolean isBonusNumberCorrect) {
        if (countOfMatch < WINNING_MIN_COUNT) {
            return FAILURE;
        }
        if (countOfMatch == WINNING_CORRECT_5 && isBonusNumberCorrect){
            return SECOND_PLACE;
        }
        for (Rank rank : values()) {
            if (rank.matchCount(countOfMatch)) {
                return rank;
            }
        }
        throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
    }

    public String getDisplayText() {
        return displayText;
    }

    public Money prize(int countOfMatchLotto) {
        return new Money(countOfMatchLotto * winningMoney);
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }
}
