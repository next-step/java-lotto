package enums;

import java.util.Arrays;

public enum WinnerInfo {

    NOT_MATCH(0, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    private int matchFound;
    private int winningMoney;

    WinnerInfo(int matchFound, int winningMoney) {
        this.matchFound = matchFound;
        this.winningMoney = winningMoney;
    }

    public static int getWinningMoney(int matchFound) {
        return Arrays.stream(values())
            .filter(it -> it.matchFound == matchFound)
            .findFirst()
            .orElseGet(() -> NOT_MATCH)
            .getWinningMoney();
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
