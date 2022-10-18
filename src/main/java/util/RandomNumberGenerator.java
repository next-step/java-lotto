package util;

import java.util.Random;

public class RandomNumberGenerator implements RandomGenerator<Integer> {
    private static final int DEFAULT_BOUND = 10;

    private static final Random random = new Random();

    protected RandomNumberGenerator() { }

    public static RandomNumberGenerator getInstance() {
        return LazyHolder.instance;
    }

    @Override
    public Integer generate() {
        return this.generate(DEFAULT_BOUND);
    }

    public Integer generate(int bound) {
        return random.nextInt(bound);
    }

    public Integer generateNonZero(int bound) {
        if (bound == 1) {
            throw new IllegalArgumentException("경계값이 1보다 큰 값이여야 합니다.");
        }

        return random.nextInt(bound - 1) + 1;
    }

    private static class LazyHolder {
        private static final RandomNumberGenerator instance = new RandomNumberGenerator();
    }
}
