package lotto.util;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberGenerateUtil {

    private static final int MIN_NUMBER_BOUND = 1;

    private NumberGenerateUtil() {
    }

    public static Set<Integer> generateNumbers(int bound, int size) {
        return new Random().ints(MIN_NUMBER_BOUND, bound)
                .distinct()
                .limit(size)
                .boxed()
                .collect(Collectors.toSet());
    }
}
