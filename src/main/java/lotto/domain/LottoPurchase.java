package lotto.domain;

import lotto.util.Util;

import java.util.stream.IntStream;

public class LottoPurchase {

    private static final int LOTTO_PRICE = 1000;
    private static final int START = 0;
    private int auto;

    public LottoPurchase(String totalMoney) {
        this.auto = calculateAuto(totalMoney);
    }

    private int calculateAuto(String totalMoney) {
        return Util.convertInt(totalMoney) / LOTTO_PRICE;
    }

    public IntStream autoStream() {
        return IntStream.range(START, auto);
    }


    @Override
    public String toString() {
        return String.format("%s개를 구매했습니다.", auto);
    }
}
