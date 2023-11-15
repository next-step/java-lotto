package lotto.model.constants;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Dividend {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int correctCount;
    private final long dividendAmount;

    Dividend(int correctCount, long dividendAmount) {
        this.correctCount = correctCount;
        this.dividendAmount = dividendAmount;
    }

    public static Dividend getDividend(int correctCount) {
        return Arrays.stream(values())
                .filter(dividend -> dividend.correctCount == correctCount)
                .findAny().orElseThrow(() -> new IllegalArgumentException("3 ~ 6사이의 값을 입력해주세요."));
    }

    public long dividendAmount() {
        return this.dividendAmount;
    }

}
