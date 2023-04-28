package lotto.domain;

public enum Prize {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false);

    private final int matchCount;
    private final int prizeAmount;
    private final boolean bonusNumberMatch;

    Prize(int matchCount, int prizeAmount, boolean bonusNumberMatch) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.bonusNumberMatch = bonusNumberMatch;
    }

    public boolean isMatch(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int calculatePrize(int count) {
        return this.prizeAmount * count;
    }
}
