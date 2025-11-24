package lotto.model;


import java.util.Arrays;

public enum Prize {
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    SIX_MATCHES(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeValue;

    Prize(int matchCount, int prizeValue) {
        this.matchCount = matchCount;
        this.prizeValue = prizeValue;
    }

    public int value() {
        return prizeValue;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%s원)", matchCount, prizeValue);
    }

    static Prize fromMatchCount(int matchCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 일치 값입니다. " + matchCount));
    }
}
