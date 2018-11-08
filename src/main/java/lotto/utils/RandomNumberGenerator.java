package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator {

    private static Random random = new Random();

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }

    public static List<Integer> generate(int min, int max, int disits) {
        List<Integer> numbers = getRangeNumber(min, max);
        Collections.shuffle(numbers);
        return numbers.subList(0, disits);
    }

    private static List<Integer> getRangeNumber(int min, int max) {
        return IntStream.range(min, max).boxed().collect(Collectors.toList());
    }
}
