package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIFTH(3, 5000),
    FOURTH(3, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int matchCount;
    private int money;

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
                .orElseThrow(IllegalArgumentException::new);
    }

    private Prize checkPrizeSecond(boolean match) {
        if(this.matchCount ==5 && match){
            return Prize.SECOND;
        }
        return this;
    }

    public int sumMoney(int totalMoney) {
        return money + totalMoney;
    }


}
