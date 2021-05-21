package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    public static List<String> randomSixNumbers() {
        List<String> availableNumbers = availableAllNumbers();
        Collections.shuffle(availableNumbers);

        return availableNumbers.subList(0, 6);
    }

    private static List<String> availableAllNumbers() {
        return IntStream.range(1, 45)
                .mapToObj(number -> String.valueOf(number))
                .collect(Collectors.toList());
    }
}
