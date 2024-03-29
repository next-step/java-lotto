package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGeneratorImpl implements NumbersGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final Numbers numbers;

    public RandomNumbersGeneratorImpl() {
        this.numbers = new Numbers(
                IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                        .mapToObj(Number::new)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Numbers generate() {
        numbers.shuffle();
        List<Number> selectedNumbers = numbers.getNumberList().stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());

        return new Numbers(Collections.unmodifiableList(selectedNumbers));
    }
}
