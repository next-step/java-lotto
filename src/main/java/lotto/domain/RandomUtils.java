package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomUtils {

    private static final Random defaultRandom = ThreadLocalRandom.current();

    private RandomUtils() {
    }

    public static List<Integer> pickUniqueNumbersInRange(
        final int startInclusive,
        final int endInclusive,
        final int count
    ) {
        validateRange(startInclusive, endInclusive);
        validateCount(startInclusive, endInclusive, count);
        final Set<Integer> randomUniqueNumbers = new LinkedHashSet<>(count);
        while (randomUniqueNumbers.size() < count) {
            randomUniqueNumbers.add(pickNumbersInRange(startInclusive, endInclusive));
        }
        return new ArrayList<>(randomUniqueNumbers);
    }

    private static int pickNumbersInRange(final int startInclusive, final int endInclusive) {
        validateRange(startInclusive, endInclusive);
        return startInclusive + defaultRandom.nextInt(endInclusive - startInclusive + 1);
    }

    private static void validateCount(
        final int startInclusive,
        final int endInclusive,
        final int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count cannot be less than zero");
        }
        if (endInclusive - startInclusive + 1 < count) {
            throw new IllegalArgumentException("count cannot be greater than the input range");
        }
    }

    private static void validateRange(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException(
                "startInclusive cannot be greater than endInclusive");
        }
        if (endInclusive == Integer.MAX_VALUE) {
            throw new IllegalArgumentException(
                "endInclusive cannot be greater than Integer MAX_VALUE");
        }
        if (endInclusive - startInclusive >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("the input range is too large");
        }
    }
}
