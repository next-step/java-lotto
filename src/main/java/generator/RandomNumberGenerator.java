package generator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private final List<Integer> numbers;

    public RandomNumberGenerator() {
        numbers = Stream.iterate(START_NUMBER, i -> i + 1)
                .limit(END_NUMBER)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> generate() {
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
