package enums;

import java.util.Arrays;

public enum LottoWinnerRank {

    NOT_MATCH(0, 0),
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    SIX_MATCH(6, 2_000_000_000);

    private int matchFound;
    private int winningMoney;

    LottoWinnerRank(int matchFound, int winningMoney) {
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
