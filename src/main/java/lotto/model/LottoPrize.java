package lotto.model;

import java.util.Arrays;

public enum LottoPrize {

FOURTH(3, 5_000),
THIRD(4, 50_000),
SECOND(5, 1_500_000),
FIRST(6, 2_000_000_000);

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
