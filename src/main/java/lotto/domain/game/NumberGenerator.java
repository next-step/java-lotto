package lotto.domain.game;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class NumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public NumberGenerator() {
        numbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        return IntStream.rangeClosed(MIN_NUMBER,
                MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());
    }

    public List<Integer> shuffleNumbers() {
        Collections.shuffle(numbers);
        return numbers;
    }

}
