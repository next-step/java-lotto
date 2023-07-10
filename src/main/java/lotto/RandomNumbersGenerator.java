package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class RandomNumbersGenerator implements NumbersGenerator {

    private static final RandomNumbersGenerator INSTANCE = new RandomNumbersGenerator();

    private static final List<Integer> baseNumbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toUnmodifiableList());

    private RandomNumbersGenerator() {
    }

    public static RandomNumbersGenerator getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Integer> generate() {
        return baseNumbers.subList(0, 6);
    }
}
