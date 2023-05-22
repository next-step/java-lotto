package lotto.domain.result;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_RANK(0, 0);

    private final int hit;
    private final int reward;

    Rank(int hit, int reward) {
        this.hit = hit;
        this.reward = reward;
    }

    public static Rank valueOf(int hit, boolean hasBonusNumber) {
        if (hit == 5) {
            return hasBonusNumber ? Rank.SECOND : Rank.THIRD;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.getHit() == hit)
                .findFirst()
                .orElse(NO_RANK);
    }

    public int getHit() {
        return hit;
    }

    public int getReward() {
        return reward;
    }

    public Long initialRank() {
        return 0L;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "hit=" + hit +
                ", reward=" + reward +
                '}';
    }
}
