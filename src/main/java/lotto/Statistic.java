package lotto;

import java.util.Arrays;

public enum Statistic {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int winnings;

    Statistic(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public static Statistic findRank(int matchCount) {
        return Arrays.stream(values())
                .filter(statistic -> statistic.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("3미만의 당첨 개수는 산정하지 않습니다."));
    }
}
