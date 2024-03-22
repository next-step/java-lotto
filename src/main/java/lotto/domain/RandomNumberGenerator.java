package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Rule.*;

public class RandomNumberGenerator implements NumberGenerateStrategy {

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = IntStream.rangeClosed(MIN_NUMBER.getValue(), MAX_NUMBER.getValue())
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(0, NUMBERS_OF_BALLS.getValue());
    }

}
