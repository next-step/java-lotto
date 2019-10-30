package step3;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int match;
    private int winningMoney;

    Prize(int match, int winningMoney) {
        this.match = match;
        this.winningMoney = winningMoney;
    }

    public static Prize matchOfCount(int match, boolean hasBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.match == match)
                .filter(prize->!prize.equals(SECOND) || hasBonus)
                .findFirst()
                .orElse(MISS);
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
