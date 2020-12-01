package lotto;

import java.util.Random;

public class RandomUtils {

    protected static final int LOWER_BOUND = 1;

    protected static final int HIGHER_BOUND = 45;

    private static final Random random = new Random();

    private RandomUtils() {}

    public static int nextInt() {
        return LOWER_BOUND + random.nextInt(HIGHER_BOUND);
    }
}
