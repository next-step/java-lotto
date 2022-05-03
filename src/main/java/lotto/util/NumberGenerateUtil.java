package lotto.util;

import lotto.exception.InvalidNumberBoundException;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberGenerateUtil {

    private static final int MIN_NUMBER_BOUND = 1;
    private static final Random RANDOM = new Random();

    private NumberGenerateUtil() {
    }

    public static Set<Integer> generateNumbers(int bound, int size) {
        validBound(bound, size);
        return RANDOM.ints(MIN_NUMBER_BOUND, bound)
                .distinct()
                .limit(size)
                .boxed()
                .collect(Collectors.toSet());
    }

    private static void validBound(int bound, int size) {
        if (bound <= size) {
            throw new InvalidNumberBoundException();
        }
    }
}
