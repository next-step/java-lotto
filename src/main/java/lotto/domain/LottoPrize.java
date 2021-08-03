package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, 1, 2_000_000_000),
    SECONDE(5, 2, 30_000_000),
    THIRD(5, 3, 1_500_000),
    FOURTH(4, 4, 50_000),
    FIFTH(3, 5, 5_000),
    NONE(0, 0, 0)
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
