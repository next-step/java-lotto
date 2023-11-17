package lotto.util;

import java.util.Random;

public class RandomGenerator {

    private static final int UPPER_BOUND = 45;
    private static final int LOWER_BOUND = 1;

    private final Random random;

    private RandomGenerator(Random random) {
        this.random = random;
    }

    public static RandomGenerator getInstance() {
        return RandomHolder.INSTANCE;
    }

    public int number() {
        return random.nextInt(UPPER_BOUND - LOWER_BOUND) + LOWER_BOUND;
    }

    private static class RandomHolder {

        private static final RandomGenerator INSTANCE = new RandomGenerator(new Random());
    }
}
