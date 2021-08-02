package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6,1,200000000),
    SECOND(5,2,1500000),
    THIRD(4,3,50000),
    FOURTH(3,4,5000),
    NONE(0,0,0)
    ;
    private int count;
    private int prize;
    private int money;

    LottoPrize(int count, int prize, int money) {
        this.count = count;
        this.prize = prize;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public int getMoney() {
        return money;
    }

    public static LottoPrize findLottoPrizeOfCount(int count){
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.getCount() == count)
                .findFirst()
                .orElse(NONE);
    }

    public static LottoPrize findLottoPrizeOfPrize(int prize){
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.getPrize() == prize)
                .findFirst()
                .orElse(NONE);
    }

    public int calculate(int count){
        return this.money * count;
    }

}
