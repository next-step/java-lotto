package lotto.domain;

public enum Prize {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    BOOM(0, 0, false);

    private final int matchCount;
    private final int prizeAmount;
    private final boolean bonusNumberMatch;

    Prize(int matchCount, int prizeAmount, boolean bonusNumberMatch) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.bonusNumberMatch = bonusNumberMatch;
    }

    public static Prize calculatePrize(int matchCount, boolean containsBonuns) {
        if (matchCount < FIFTH.matchCount) {
            return BOOM;
        }
        if (matchCount == FIFTH.matchCount) {
            return FIFTH;
        }
        if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        }
        if ((matchCount == THIRD.matchCount) && (containsBonuns == THIRD.bonusNumberMatch)) {
            return THIRD;
        }
        if ((matchCount == SECOND.matchCount) && (containsBonuns == SECOND.bonusNumberMatch)) {
            return SECOND;
        }
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        }
        throw new RuntimeException("알수없는 계산 에러..");
    }

    public boolean isMatch(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int calculatePrize(int count) {
        return this.prizeAmount * count;
    }
}
