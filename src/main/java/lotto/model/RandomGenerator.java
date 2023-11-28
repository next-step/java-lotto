package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerator {

    private final static int LOW_BOUND = 1;
    private final static int MAX_BOUND = 45;
    private final List<Integer> numbers;

    public RandomGenerator() {
        numbers = new ArrayList<>();
        IntStream.rangeClosed(LOW_BOUND, MAX_BOUND).forEach(numbers::add);
    }

    public List<Integer> generate() {
        Collections.shuffle(numbers);
        return IntStream.range(0, 6).mapToObj(numbers::get)
            .sorted()
            .collect(Collectors.toList());
    }
}
