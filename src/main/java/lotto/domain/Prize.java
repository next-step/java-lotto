package lotto.domain;

import java.util.Arrays;

public enum Prize {

    ZERO(0, 0, ""),
    THREE(3, 5000, "3개 일치 (5000원)"),
    FOUR(4, 50_000, "4개 일치 (50000원)"),
    FIVE(5, 1_500_000, "5개 일치 (15000000원)"),
    SIX(6, 2_000_000_000, "6개 일치 (2000000000원)");

    private final int winningCount;
    private final int reward;
    private final String message;

    Prize(int winningCount, int reward, String message) {
        this.winningCount = winningCount;
        this.reward = reward;
        this.message = message;
    }

    public static Prize of(int winningCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.winningCount == winningCount)
                .findAny()
                .orElse(Prize.ZERO);
    }

    public String getMessage() {
        return message;
    }

    public int getReward() {
        return reward;
    }
}
