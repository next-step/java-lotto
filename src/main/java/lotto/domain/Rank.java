package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치 (2000000000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1500000원)"),
    FOURTH(4, 50_000, "4개 일치 (50000원)"),
    FIFTH(3, 5_000, "3개 일치 (5000원)"),
    MISS(0, 0, "");

    private static final int WINNING_MIN_COUNT = 3;

    private final int countOfMatch;
    private final int winningMoney;
    private final String displayText;

    private Rank(int countOfMatch, int winningMoney, String displayText) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }

    public Money prize(int countOfMatchLotto) {
        return new Money(countOfMatchLotto * winningMoney);
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < WINNING_MIN_COUNT) {
            return MISS;
        }

        if (SECOND.matchCount(countOfMatch) && matchBonus) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.matchCount(countOfMatch)) {
                return rank;
            }
        }

        throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }
}
