package lotto.domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    private static final Random RANDOM = ThreadLocalRandom.current();

    private RandomGenerator() {
    }

    public static Set<Integer> randomNumbers(int requestSize, int start, int end) {
        validate(requestSize, start, end);

        Set<Integer> result = new HashSet<>();
        while (result.size() != requestSize) {
            result.add(randomNumberBetween(start, end));
        }

        return result;
    }

    private static void validate(int size, int start, int end) {
        if (isRangeOver(size, start, end)) {
            throw new IllegalArgumentException("크기 또는 범위가 올바르지 않습니다.");
        }
    }

    private static boolean isRangeOver(int size, int start, int end) {
        return end - start + 1 < size;
    }

    private static int randomNumberBetween(int start, int end) {
        return start + RANDOM.nextInt(end - start + 1);
    }
}
