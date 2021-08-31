package lotto.util;

import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE;
import static lotto.domain.Lotto.SAVED_MAX_NUMBER;
import static lotto.domain.Lotto.SAVED_MIN_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Number;

public class RandomNumbersGenerator {

    private static final int GENERATE_MIN_NUMBER = 0;

    private static final List<Number> lottoNumbers = IntStream.rangeClosed(SAVED_MIN_NUMBER, SAVED_MAX_NUMBER)
        .boxed()
        .map(Number::new)
        .collect(Collectors.toList());

    private RandomNumbersGenerator() {
    }

    public static List<Number> generateNumbers() {
        Collections.shuffle(lottoNumbers);
        List<Number> numbers = new ArrayList<>();
        for (int i = GENERATE_MIN_NUMBER; i < LOTTO_NUMBERS_SIZE; i++) {
            numbers.add(lottoNumbers.get(i));
        }
        Collections.sort(numbers);
        return numbers;
    }

}
