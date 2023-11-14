package lotto.model.constants;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Dividend {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private int correctCount;
    private long dividendAmount;

    Dividend(int correctCount, long dividendAmount) {
        this.correctCount = correctCount;
        this.dividendAmount = dividendAmount;
    }

    public static Dividend getDividend(int correctCount) {
        return Arrays.stream(values())
                .filter(dividend -> dividend.correctCount == correctCount)
                .findAny().get();
    }

    public static long getMoney(int correctCount, int winCount) {
        return Arrays.stream(values())
                .filter(dividend -> dividend.correctCount == correctCount)
                .findAny().get().dividendAmount * winCount;
    }

    @Override
    public String toString() {
        return correctCount + "개 일치 (" + dividendAmount + "원) - ";
    }
}
