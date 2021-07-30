package lotto.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static int nextInt(final int startInclusive, final int endInclusive) {
        return ThreadLocalRandom.current().nextInt(startInclusive, endInclusive + 1);
    }
}
