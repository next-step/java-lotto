package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static util.Constants.LOTTO_NUMBER;
import static util.Constants.LOTTO_NUMBER_RANGE_HIGH;

public class RandomUtils {
    private static Random RANDOM = new Random();

    public static int[] createNumbers() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < LOTTO_NUMBER) {
            numbers.add(RANDOM.nextInt(LOTTO_NUMBER_RANGE_HIGH) + 1);
        }

        return numbers.stream().mapToInt(Number::intValue).toArray();
    }
}
