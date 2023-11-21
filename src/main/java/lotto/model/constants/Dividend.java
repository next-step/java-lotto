package lotto.model.constants;

import java.util.Arrays;

public enum Dividend {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false),
    ;

    private final int correctCount;
    private final long dividendAmount;
    private final boolean hasBonus;

    Dividend(int correctCount, long dividendAmount, boolean hasBonus) {
        this.correctCount = correctCount;
        this.dividendAmount = dividendAmount;
        this.hasBonus = hasBonus;
    }

    public int correctCount() {
        return this.correctCount;
    }

    public static Dividend valueOf(int correctCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(dividend -> dividend.correctCount == correctCount)
                .filter(dividend -> dividend.hasBonus == matchBonus)
                .findFirst()
                .orElse(MISS);
    }

    public long dividendAmount() {
        return this.dividendAmount;
    }

}
