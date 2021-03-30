package lotto.domain;

public enum LottoRank {
    LOSE(0, false, 0),
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private final int matchCount;
    private final boolean matchBonusTarget;
    private final long winAmount;

    LottoRank(int matchCount, boolean matchBonusTarget, long winAmount) {
        this.matchCount = matchCount;
        this.matchBonusTarget = matchBonusTarget;
        this.winAmount = winAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonusTarget() {
        return matchBonusTarget;
    }

    public long getWinAmount() {
        return winAmount;
    }

    public static LottoRank inquiryRank(int matchCount, boolean matchBonus) {
        if (isLose(matchCount)) {
            return LOSE;
        }
        for (LottoRank rank : LottoRank.values()) {
            if (rank.match(matchCount, matchBonus)) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }

    private static boolean isLose(int matchCount) {
        return matchCount >= LOSE.getMatchCount() && matchCount < FIFTH.getMatchCount();
    }

    private boolean match(int matchCount, boolean matchBonus) {
        return this.matchBonusTarget ? matchCount(matchCount) && matchBonus : matchCount(matchCount);
    }

    private boolean matchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

}
