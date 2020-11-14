package lotto.domain;

import java.util.Arrays;

import static lotto.domain.Utils.makeRangeNumbers;

public enum WinningRank {
    FIRST(makeRangeNumbers(6, 7)),
    SECOND(makeRangeNumbers(5, 6)),
    THIRD(makeRangeNumbers(4, 5)),
    FOURTH(makeRangeNumbers(3, 4)),
    FAIL(makeRangeNumbers(0, 3));

    private final Numbers sameNumberNums;

    WinningRank(Numbers sameNumberNums) {
        this.sameNumberNums = sameNumberNums;
    }

    static WinningRank getWinningRank(int sameNumberNum) {
        return Arrays.stream(WinningRank.values())
                .filter(winningRank -> winningRank.sameNumberNums.contains(sameNumberNum))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Wrong Same Number Count:" + sameNumberNum));
    }
}
