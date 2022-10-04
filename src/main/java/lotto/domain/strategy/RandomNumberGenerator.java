package lotto.domain.strategy;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGeneratable {
    private static final int SIZE = 6;
    private static final int MAX_VALUE = 45;
    private static final List<Integer> NUMBERS = IntStream.rangeClosed(1, MAX_VALUE).boxed().collect(toList());
    
    @Override
    public List<Integer> generate() {
        return sort(generateRandomNumbers());
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>(NUMBERS);
        Collections.shuffle(numbers);
        return numbers.subList(0, SIZE);
    }
    
    private List<Integer> sort(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
