package lotto.util;

import java.util.Random;

public class LottoNumberGenerator {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private static final Random random = new Random();

    public static int generateNumber() {
        return random.nextInt(MAXIMUM_LOTTO_NUMBER) + MINIMUM_LOTTO_NUMBER;
    }
}
