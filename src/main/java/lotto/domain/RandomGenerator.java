package lotto.domain;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    private static final Random RANDOM = ThreadLocalRandom.current();

    private RandomGenerator() {
    }

    public static int randomNumberBetween(int start, int end) {
        return start + RANDOM.nextInt(end - start + 1);
    }
}
