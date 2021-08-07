package lotto;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum SameNumbersCount {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int sameNumbersCount;
    private final int prizeMoney;
    private int count;

    SameNumbersCount(int sameNumbersCount, int prizeMoney) {
        this.sameNumbersCount = sameNumbersCount;
        this.prizeMoney = prizeMoney;
    }

    public static SameNumbersCount getSameNumbersCount(long sameCount) {
        SameNumbersCount count = Arrays.stream(values())
                .filter(sameNumbersCount -> sameNumbersCount.sameNumbersCount == sameCount)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        count.addCount();
        return count;
    }

    public void addCount() {
        count += 1;
    }

    public int getSameNumbersCount() {
        return sameNumbersCount;
    }

    public int getCount() {
        return count;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
