package lotto.domain;

import java.util.Arrays;

import static lotto.domain.Utils.makeRangeNumbers;

public enum WinningRank {
    FAIL(makeRangeNumbers(0, 3), 0),
    FOURTH(makeRangeNumbers(3, 4), 5000),
    THIRD(makeRangeNumbers(4, 5), 50000),
    SECOND(makeRangeNumbers(5, 6), 1500000),
    FIRST(makeRangeNumbers(6, 7), 2000000000);

    private final Numbers sameNumberNums;
    private final int price;

    WinningRank(Numbers sameNumberNums, int price) {
        this.sameNumberNums = sameNumberNums;
        this.price = price;
    }

    static WinningRank getWinningRank(int sameNumberNum) {
        return Arrays.stream(WinningRank.values())
                .filter(winningRank -> winningRank.sameNumberNums.contains(sameNumberNum))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Wrong Same Number Count:" + sameNumberNum));
    }

    public int getPrice() {
        return price;
    }

    public Numbers getSameNumberNums() {
        return sameNumberNums;
    }

    public boolean isFail() {
        return this == WinningRank.FAIL;
    }
}
