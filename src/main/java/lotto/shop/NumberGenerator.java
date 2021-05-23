package lotto.shop;

import lotto.lotto.LottoNumber;

import java.util.Random;

public class NumberGenerator {
    private final static Random random = new Random();

    public static int generate() {
        return random.nextInt(LottoNumber.MAX_NUMBER) + LottoNumber.MIN_NUMBER;
    }
}
