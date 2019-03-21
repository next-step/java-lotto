package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static int getRandomNumber(int bits) {
        return RANDOM.nextInt(bits);
    }

    public static int[] createNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 6) {
            numbers.add(getRandomNumber(45));
        }
        return numbers.stream().mapToInt(Number::intValue).toArray();
    }
}