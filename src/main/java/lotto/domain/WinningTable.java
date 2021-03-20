package lotto.domain;

import java.util.Arrays;

public enum WinningTable {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    public int matchNumber;
    public int winningAmount;

    WinningTable(int matchNumber, int winningAmount) {
        this.matchNumber = matchNumber;
        this.winningAmount = winningAmount;
    }

    int multiply(int quantity) {
        return winningAmount * quantity;
    }

    public static WinningTable of(int matchNumber) {
        return Arrays.stream(WinningTable.values())
                .filter(winningTable -> winningTable.matchNumber == matchNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 유형이 존재하지 않습니다."));
    }
}
