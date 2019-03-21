package lotto;

import lotto.domain.LottoNumber;

import java.util.Random;

public class LottoRandomNumberGenerator {
    public static final int BOUND = 45;
    private static Random random = new Random();

    public static LottoNumber next() {
        return new LottoNumber(random.nextInt(BOUND) + 1);
    }
}
