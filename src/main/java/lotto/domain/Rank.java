package lotto.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Rank {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int sameNumbersCount;
    private final int prizeMoney;

    Rank(int sameNumbersCount, int prizeMoney) {
        this.sameNumbersCount = sameNumbersCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank getRank(long sameCount) {
        return Arrays.stream(values())
                .filter(RANK -> RANK.sameNumbersCount == sameCount)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public int getSameNumbersCount() {
        return sameNumbersCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
