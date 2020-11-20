package lotto.domain;

import java.util.Arrays;

public enum WinningRank {
    FAIL(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int sameNumberNum;
    private final int price;

    WinningRank(int sameNumberNum, int price) {
        this.sameNumberNum = sameNumberNum;
        this.price = price;
    }

    public static WinningRank getWinningRank(int sameNumberNum) {
        return Arrays.stream(WinningRank.values())
                .filter(winningRank -> winningRank.sameNumberNum == sameNumberNum)
                .findAny()
                .orElse(WinningRank.FAIL);
    }

    public int getPrice() {
        return price;
    }

    public int getSameNumberNum() {
        return sameNumberNum;
    }

    public boolean isFail() {
        return this == WinningRank.FAIL;
    }

    public int getTotalPrice(int num) {
        return price * num;
    }
}
