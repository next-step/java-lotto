package lotto.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static int nextInt(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException();
        }
        return ThreadLocalRandom
                .current()
                .nextInt(startInclusive, endInclusive + 1);
    }
}
