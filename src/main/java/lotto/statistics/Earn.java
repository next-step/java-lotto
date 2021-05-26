package lotto.statistics;

import java.util.Arrays;

public enum Earn {
    THREE_MATCHED(3, 5_000),
    FOUR_MATCHED(4, 50_000),
    FIVE_MATCHED(5, 1_500_000),
    SIX_MATCHED(6, 2_000_000_000);

    private int matchCount;
    private int earn;

    Earn(int matchCount, int earn) {
        this.matchCount = matchCount;
        this.earn = earn;
    }

    public static Earn match(int matchCount) {
        return Arrays.stream(values())
            .filter(value -> value.matchCount == matchCount)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("match count는 3, 4, 5, 6만 사용이 가능합니다"));
    }

    public int winningPrice() {
        return earn;
    }

    public String message(int repeatedCount) {
        return new StringBuffer()
            .append(matchCount)
            .append("개 일치 (")
            .append(earn)
            .append("원)- ")
            .append(repeatedCount)
            .append("개\n")
            .toString();
    }

}
