package lotto.domain;

import lotto.util.Util;

import java.util.stream.IntStream;

public class LottoPurchase {

    private static final int LOTTO_PRICE = 1000;
    private static final int START = 0;
    private int auto;
    private int manual;


    public LottoPurchase(String totalMoney, String manual) {
        this.manual = Util.convertInt(manual);
        this.auto = calculateAuto(totalMoney);
    }

    private int calculateAuto(String totalMoney) {
        return Util.convertInt(totalMoney) / LOTTO_PRICE - this.manual;
    }

    public IntStream autoStream() {
        return IntStream.range(START, auto);
    }

    public IntStream manualStream() {
        return IntStream.range(START, manual);
    }

    @Override
    public String toString() {
        return String.format("수동으로 %s장, 자동으로 %s개를 구매했습니다.", manual, auto);
    }
}
