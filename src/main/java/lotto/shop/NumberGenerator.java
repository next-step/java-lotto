package lotto.shop;

import java.util.Random;

public class NumberGenerator {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private final Random random;

    public NumberGenerator() {
        random = new Random();
    }

    public int generate() {
        return random.nextInt(MAX_NUM) + MIN_NUM;
    }
}
