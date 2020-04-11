package lotto.generator;

import java.util.Random;

public class RandomNumber implements NumberGenerator {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;

    @Override
    public int generate() {
        return new Random().nextInt(LOTTO_MAX_NUMBER) + LOTTO_MIN_NUMBER;
    }
}
