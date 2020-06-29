package lotto.domain;

import java.util.Arrays;

public enum Prize {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 500_00),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private int matchCount;
    private int money;
    private static final int SECOND_PRIZE_MATCH_COUNT = 5;

    Prize(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;

    }

    public boolean isSameMatchCount(int matchCount) {

        return this.matchCount == matchCount;
    }

    public int getMoney() {
        return money;
    }

    public static Prize findByPrize(int matchCount, boolean match) {
        return Arrays.stream(values())
                .filter(prize -> prize.isSameMatchCount(matchCount))
                .map(prize -> prize.checkPrizeSecond(match))
                .findFirst()
                .orElse(Prize.MISS);
    }

    private Prize checkPrizeSecond(boolean match) {

        if (this.matchCount == SECOND_PRIZE_MATCH_COUNT && match) {
            return Prize.SECOND;
        }
        return this;
    }

    public long sumMoney(long totalMoney) {
        return money + totalMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
