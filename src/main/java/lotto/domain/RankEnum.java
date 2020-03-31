package lotto.domain;

import java.util.Arrays;

public enum RankEnum {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private int matched;
    private int reward;

    RankEnum(int matched, int reward) {
        this.matched = matched;
        this.reward = reward;
    }

    public int getMatched() {
        return this.matched;
    }

    public int getReward() {
        return this.reward;
    }

    public static int getMinMatched() {
        return FIRST.matched;
    }

    public static int getMaxMatched() {
        return FIFTH.matched;
    }

    private static boolean isWinning(int matched) {
        return Arrays.stream(RankEnum.values())
                .anyMatch(r -> r.getMatched() == matched);
    }

    public static int calculateReward(int matched, int count) {
        if (RankEnum.isWinning(matched)) {
            return RankEnum.getRewardFromMatched(matched) * count;
        }
        return 0;
    }

    public static int getRewardFromMatched(int matched) {
        return Arrays.stream(RankEnum.values())
                .filter(r -> r.getMatched() == matched)
                .mapToInt(r -> r.getReward())
                .findFirst()
                .orElse(0);
    }

}
