package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIFTH(3, 5000, "3개 일치"),
    FOURTH(4, 50000, "4개 일치"),
    THIRD(5, 1500000, "5개 일치"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2000000000, "6개 일치");

    private int matchCount;
    private int money;
    private String detail;
    private static final int SECOND_PRIZE_MATCH_COUNT = 5;

    Prize(int matchCount, int money, String detail) {
        this.matchCount = matchCount;
        this.money = money;
        this.detail = detail;
    }

    public boolean isSameMatchCount(int matchCount) {

        return this.matchCount == matchCount;
    }

    public int getMoney() {
        return money;
    }
    
    public String getDetail() {
        return detail;
    }

    public static Prize findByPrize(int matchCount, boolean match) {
        return Arrays.stream(values())
                .filter(prize -> prize.isSameMatchCount(matchCount))
                .map(prize -> prize.checkPrizeSecond(match))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
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


}
