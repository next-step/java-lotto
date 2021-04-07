package lotto.model;

import java.util.Arrays;

public enum LottoPrize {

    FIRST(6,2000000000),
    SECOND(5,1500000),
    THIRD(4,50000),
    FOURTH(3,5000);

    private int matchs;
    private int prize;

    LottoPrize(int matchs, int prize) {
        this.matchs = matchs;
        this.prize = prize;
    }

    public static LottoPrize getByMathes(int matchs) {
        return Arrays.stream(LottoPrize.values()).filter(lottoPrize -> lottoPrize.getMatchs() == matchs).findFirst().orElse(null);
    }

    public int getMatchs() {
        return matchs;
    }

    public int getPrize() {
        return prize;
    }
}
