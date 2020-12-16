package step2;

import step2.ui.OutputHandler;

import java.util.Arrays;

public enum WinResult {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private WinResult(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static WinResult valueOf(MatchCount matchCount) {
        if (matchCount.getValue() < FOURTH.countOfMatch) {
            return MISS;
        }
        return Arrays.asList(values()).stream()
                .filter(item -> matchCount.isSame(item.countOfMatch))
                .findFirst()
                .get();
    }



}
