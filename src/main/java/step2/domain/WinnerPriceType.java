package step2.domain;

import java.util.Arrays;

public enum WinnerPriceType {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    public int matchNumber;
    public double winningAmount;

    WinnerPriceType(int matchNumber, int winningAmount) {
        this.matchNumber = matchNumber;
        this.winningAmount = winningAmount;
    }

    public static WinnerPriceType of(int matchNumber) {
        return Arrays.stream(WinnerPriceType.values())
                .filter(winningTable -> winningTable.matchNumber == matchNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 유형이 존재하지 않습니다."));
    }
}
