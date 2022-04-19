package lotto.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberUtil {

    private RandomNumberUtil() {
    }

    public static Set<Integer> generateNumbers(int bound, int numberSize) {
        Set<Integer> numbers = new HashSet<>();

        while(numbers.size() < numberSize) {
            int number = generateNumber(bound);
            if (numbers.contains(number) || isInvalidNumber(number, bound)) {
                continue;
            }
            numbers.add(number);
        }

        return numbers;
    }

    private static boolean isInvalidNumber(int number, int maxBound) {
        return ((number > maxBound) || (number <= 0));
    }

    private static int generateNumber(int bound) {
        return new Random().nextInt(bound);
    }

}
