package lotto.domain;

public enum Reward {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    Reward(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Reward valueOf(MatchResult matchResult) {
        if (Reward.FIRST.matchCount == matchResult.count()) {
            return FIRST;
        }
        if (Reward.SECOND.matchCount == matchResult.count()) {
            if (matchResult.isBonusMatched()) {
                return SECOND;
            }
            return THIRD;
        }
        if (Reward.FOURTH.matchCount == matchResult.count()) {
            return FOURTH;
        }
        if (Reward.FIFTH.matchCount == matchResult.count()) {
            return FIFTH;
        }
        return NONE;
    }

    public int prize() {
        return prize;
    }
}
