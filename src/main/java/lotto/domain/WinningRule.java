package lotto.domain;

import java.util.Arrays;

public enum WinningRule {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);


    private final int match;
    private final int reward;

    WinningRule(int match, int reward) {
        this.match = match;
        this.reward = reward;
    }

    public int getMatch() {
        return match;
    }
    public int getReward() {
        return reward;
    }

    public static WinningRule findByValue(int match) {
        return Arrays.stream(WinningRule.values())
                .filter(item -> item.getMatch() == match)
                .findFirst()
                .orElseThrow(null);
    }

}
