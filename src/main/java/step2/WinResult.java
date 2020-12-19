package step2;

import java.util.Arrays;

public enum WinResult {
    FIRST(6, 2000000000, false),
    SECOND(5, 3000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    MISS(0, 0, false);

    private int countOfMatch;
    private int winningMoney;
    private boolean bonusMatch;

    private WinResult(int countOfMatch, int winningMoney, boolean bonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.bonusMatch = bonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public static WinResult valueOf(MatchResult matchCount) {
        if (matchCount.getValue() < FOURTH.countOfMatch) {
            return MISS;
        }
        return Arrays.stream(values())
                .filter(matchCount::isSame)
                .findFirst()
                .orElse(null);
    }


}
