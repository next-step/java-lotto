package lotto.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Number.MAX_NUMBER;
import static lotto.domain.Number.MIN_NUMBER;

public class LottoGenerator {

    private LottoGenerator() {
        throw new AssertionError();
    }

    public static List<Integer> generateSortedNumbers(int pickSize) {
        return pickedNumbers(pickSize)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<Integer> pickedNumbers(int pickSize) {
        return shuffledNumbers().subList(0, pickSize);
    }

    private static List<Integer> shuffledNumbers() {
        List<Integer> availableNumbers = availableNumbers();
        Collections.shuffle(availableNumbers);
        return availableNumbers;
    }

    private static List<Integer> availableNumbers() {
        return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}
