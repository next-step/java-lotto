package lotto.domain;

import java.util.Arrays;

public enum RewardEnum {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int matched;
    private int reward;

    RewardEnum(int matched, int reward) {
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
        return THREE.matched;
    }

    public static int getMaxMatched() {
        return SIX.matched;
    }

    private static boolean isWinning(int matched) {
        return Arrays.stream(RewardEnum.values())
                .anyMatch(r -> r.getMatched() == matched);
    }

    public static int calculateReward(int matched, int count) {
        if (RewardEnum.isWinning(matched)) {
            return RewardEnum.getRewardFromMatched(matched) * count;
        }
        return 0;
    }

    public static int getRewardFromMatched(int matched) {
        return Arrays.stream(RewardEnum.values())
                .filter(r -> r.getMatched() == matched)
                .mapToInt(r -> r.getReward())
                .findFirst()
                .orElse(0);
    }

}
