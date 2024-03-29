package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGeneratorImpl implements NumbersGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public RandomNumbersGeneratorImpl() {
        this.numbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> generate() {
        Collections.shuffle(this.numbers);
        return Collections.unmodifiableList(
                numbers.stream()
                        .limit(LOTTO_NUMBER_SIZE)
                        .sorted()
                        .collect(Collectors.toList())
        );
    }
}
