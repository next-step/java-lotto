package lotto.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {
    private static final Random RANDOM = ThreadLocalRandom.current();

    private RandomNumberGenerator() {
    }

    public static int generate(int start, int end) {
        return start + RANDOM.nextInt(end);
    }
}
