package step2.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomIntegerGenerator {

    private static final int RANDOM_LIMIT = 45;
    private static final int LENGTH = 6;

    public static List<Integer> getRandomInteger() {
        List<Integer> randomNumbers = Stream.iterate(0, n -> n + 1)
                .limit(RANDOM_LIMIT)
                .collect(Collectors.toList());

        Collections.shuffle(randomNumbers);

        return randomNumbers.stream()
                .limit(LENGTH)
                .sorted()
                .collect(Collectors.toList());
    }
}
