package lotto.domain;

import java.util.Arrays;

public class MatchedNumbers {

    private int[] matchedNumbersCount;

    public MatchedNumbers(final int size) {
        this.matchedNumbersCount = new int[size];
    }

    void add(final int matchedNumberCount) {
        this.matchedNumbersCount[matchedNumberCount]++;
    }

    int get(final int matchedNumberCount) {
        return this.matchedNumbersCount[matchedNumberCount];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchedNumbers that = (MatchedNumbers) o;
        return Arrays.equals(matchedNumbersCount, that.matchedNumbersCount);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matchedNumbersCount);
    }
}
