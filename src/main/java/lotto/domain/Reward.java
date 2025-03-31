package lotto.domain;

public enum Reward {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    Reward(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Reward valueOf(MatchCount matchCount) {
        if (matchCount.value() == FIRST.matchCount) {
            return FIRST;
        }
        for (Reward reward : Reward.values()) {
            if (reward.matchCount == matchCount.value()) {
                return reward;
            }
        }
        return NONE;
    }

    public int prize() {
        return prize;
    }
}
