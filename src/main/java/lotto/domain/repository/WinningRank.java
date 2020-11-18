package lotto.domain.repository;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public enum WinningRank {
    FAIL(asList(0, 1, 2), 0),
    FOURTH(singletonList(3), 5_000),
    THIRD(singletonList(4), 50_000),
    SECOND(singletonList(5), 1_500_000),
    FIRST(singletonList(6), 2_000_000_000);

    private final List<Integer> sameNumberNums;
    private final int price;

    WinningRank(List<Integer> sameNumberNums, int price) {
        this.sameNumberNums = sameNumberNums;
        this.price = price;
    }

    public static WinningRank getWinningRank(int sameNumberNum) {
        return Arrays.stream(WinningRank.values())
                .filter(winningRank -> winningRank.sameNumberNums.contains(sameNumberNum))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Wrong Same Number Count:" + sameNumberNum));
    }

    public int getPrice() {
        return price;
    }

    public List<Integer> getSameNumberNums() {
        return sameNumberNums;
    }

    public boolean isFail() {
        return this == WinningRank.FAIL;
    }

    public int getTotalPrice(int num) {
        return price * num;
    }
}
