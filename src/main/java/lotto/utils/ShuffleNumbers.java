package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffleNumbers {
    private static final List<Integer> numbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    public static List<Integer> generateSixNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(0, 6).stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
