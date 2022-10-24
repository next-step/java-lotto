package enums;

import java.util.Arrays;

public enum LottoWinnerRank {

    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private int matchFound;
    private int winningMoney;

    LottoWinnerRank(int matchFound, int winningMoney) {
        this.matchFound = matchFound;
        this.winningMoney = winningMoney;
    }

    public static int getWinningMoney(LottoWinnerRank rank) {
        return Arrays.stream(values())
            .filter(it -> it.equals(rank))
            .findFirst()
            .orElseGet(() -> MISS)
            .getWinningMoney();
    }

    public static LottoWinnerRank findKey(int matchFound) {
        return Arrays.stream(values())
            .filter(it -> it.getMatchFound() == matchFound)
            .findFirst()
            .orElseGet(() -> MISS);
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getMatchFound() {
        return matchFound;
    }
}
