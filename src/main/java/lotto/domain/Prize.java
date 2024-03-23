package lotto.domain;

import java.util.Arrays;

public enum Prize {

    NONE(0, 0),
    FIFTH_PRIZE(3, 5_000),
    FOURTH_PRIZE(4, 50_000),
    THIRD_PRIZE(5, 1_500_000),
    SECOND_PRIZE(5, 30_000_000),
    FIRST_PRIZE(6, 2_000_000_000);

    private final int winningMoney;
    private final int matchCount;

    Prize(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static Prize valueOf(int matchCount, boolean isMatchingBonusBall) {
        return Arrays.stream(values())
                .filter(p -> p.isSame(matchCount))
                // isMatchingBonusBall이 true일 때만 SECOND_PRIZE를 반환한다.
                .filter(p -> p == SECOND_PRIZE && isMatchingBonusBall)
                .findFirst()
                .orElse(Prize.valueOf(matchCount));
    }

    public static Prize valueOf(int matchCount) {
        return Arrays.stream(values())
                .filter(p -> p.isSame(matchCount))
                .findFirst()
                .orElse(NONE);
    }

    public boolean containsPrize() {
        return FOURTH_PRIZE.matchCount <= matchCount && matchCount <= FIRST_PRIZE.matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    private boolean isSame(int matchCount) {
        return this.matchCount == matchCount;
    }

}
