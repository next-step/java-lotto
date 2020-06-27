package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

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

    public String getDetail() {
        String resultDetail = matchCount + "개 일치";
        if(this == Prize.SECOND){
            resultDetail += " 보너스 볼 일치";
        }
        return resultDetail;
    }

    public static Prize findByPrize(int matchCount, boolean match) {
        return Arrays.stream(values())
                .filter(prize -> prize.isSameMatchCount(matchCount))
                .map(prize -> prize.checkPrizeSecond(match))
                .findFirst()
                .orElseThrow(() ->new IllegalArgumentException("일치하는 값이 없습니다."));
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
