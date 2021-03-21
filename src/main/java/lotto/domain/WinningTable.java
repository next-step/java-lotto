package lotto.domain;

import java.util.Arrays;

public enum WinningTable {
    FIRST(6, 2_000_000_000, "6개 일치 (2000000000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1500000원)"),
    FOURTH(4, 50_000, "4개 일치 (50000원)"),
    FIFTH(3, 5_000, "3개 일치 (5000원)"),
    MISS(0, 0, "");

    public int matchNumber;
    public int winningAmount;
    public String description;

    WinningTable(int matchNumber, int winningAmount, String description) {
        this.matchNumber = matchNumber;
        this.winningAmount = winningAmount;
        this.description = description;
    }

    int multiply(int quantity) {
        return winningAmount * quantity;
    }

    public static WinningTable of(int matchNumber) {
        return Arrays.stream(WinningTable.values())
                .filter(tmpTable -> tmpTable.matchNumber == matchNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 유형이 존재하지 않습니다."));
    }

    public static WinningTable of(int matchNumber, boolean matchBonus) {
        if (matchNumber < FIFTH.matchNumber) {
            return MISS;
        }

        WinningTable winningTable = of(matchNumber);
        if (SECOND.matchNumber == winningTable.matchNumber) {
            return matchBonus ? SECOND : THIRD;
        }
        return winningTable;

    }
}
