package step2.utils;

import java.util.Random;

public class RandomUtils {
    private static final int RANDOM_MIN_BOUND = 1;
    private static final int RANDOM_MAX_BOUND = 45;
    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int nextInt() {
        return RANDOM.nextInt(RANDOM_MAX_BOUND) + RANDOM_MIN_BOUND;
    }
}
