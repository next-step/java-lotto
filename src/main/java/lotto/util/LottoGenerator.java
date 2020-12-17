package lotto.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Number.MAX_NUMBER;
import static lotto.domain.Number.MIN_NUMBER;
import static lotto.domain.Numbers.TOTAL_NUMBER_SIZE;

public class LottoGenerator {

    private LottoGenerator() {
        throw new AssertionError();
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> availableNumbers = generateAvailableNumbers();
        Collections.shuffle(availableNumbers);
        return extractRandomNumbers(availableNumbers);
    }

    private static List<Integer> extractRandomNumbers(List<Integer> availableNumbers) {
        return availableNumbers.subList(0, TOTAL_NUMBER_SIZE)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<Integer> generateAvailableNumbers() {
        return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}
