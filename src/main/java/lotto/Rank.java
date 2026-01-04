package lotto;


import lotto.MatchResult;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치", 5),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치", 4),
    THIRD(5, false, 1_500_000, "5개 일치", 3),
    FOURTH(4, false, 50_000, "4개 일치", 2),
    FIFTH(3, false, 5_000, "3개 일치", 1),
    MISS(0, false, 0, "", 0);

    private final int matchCount;
    private final boolean bonusNeeded;
    private final int prize;
    private final String description;
    private final int displayOrder;

    Rank(int matchCount, boolean bonusNeeded, int prize, String description, int displayOrder) {
        this.matchCount = matchCount;
        this.bonusNeeded = bonusNeeded;
        this.prize = prize;
        this.description = description;
        this.displayOrder = displayOrder;
    }

    public static Rank of(MatchResult result) {
        int matchCount = result.matchCount();
        boolean bonusMatched = result.bonusMatched();

        if (matchCount == 6) return FIRST;
        if (matchCount == 5) return bonusMatched ? SECOND : THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return MISS;
    }

    public int prize() {
        return prize;
    }

    private boolean isMatch(MatchResult result) {
        if (result.matchCount() != matchCount) {
            return false;
        }
        if (!bonusRequired) {
            return true;
        }
        return result.isBonusMatched();
    }

    public int displayOrder() {
        return displayOrder;
    }

    public static Rank[] winningRanks() {
        return new Rank[]{FIFTH, FOURTH, THIRD, SECOND, FIRST};
    }
}
