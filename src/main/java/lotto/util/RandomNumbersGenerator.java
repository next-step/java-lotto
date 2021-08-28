package lotto.util;

import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE;
import static lotto.domain.Lotto.SAVED_MAX_NUMBER;
import static lotto.domain.Lotto.SAVED_MIN_NUMBER;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Number;

public class RandomNumbersGenerator {

    private static final int GENERATE_MIN_NUMBER = 0;

    private static final List<Number> numbers = IntStream.rangeClosed(SAVED_MIN_NUMBER, SAVED_MAX_NUMBER)
        .boxed()
        .map(Number::new)
        .collect(Collectors.toList());

    private RandomNumbersGenerator() {
    }

    public static List<Number> generateNumbers() {
        Collections.shuffle(numbers);
        List<Number> numbers = RandomNumbersGenerator.numbers.subList(GENERATE_MIN_NUMBER, LOTTO_NUMBERS_SIZE);
        Collections.sort(numbers);
        return numbers;
    }

}
