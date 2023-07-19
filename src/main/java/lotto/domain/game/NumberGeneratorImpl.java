package lotto.domain.game;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGeneratorImpl implements NumberGenerator {


    private List<Integer> generateNumbers() {
        return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());
    }

    @Override
    public List<Integer> shuffleNumbers() {
        List<Integer> numbers = generateNumbers();
        Collections.shuffle(numbers);
        return numbers;
    }
}
