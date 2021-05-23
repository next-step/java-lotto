package lotto.shop;

import java.util.Random;

import lotto.lotto.LottoNumber;

public class NumberGenerator {
    private static final Random random = new Random();

    public static int generate() {
        return random.nextInt(LottoNumber.MAX_NUMBER) + LottoNumber.MIN_NUMBER;
    }
}
