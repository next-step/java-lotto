package lotto.numbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllNumbers {
    public static final int LAST_NUMBER = 45;

    private final static List<Integer> allNumbers = IntStream.range(1, LAST_NUMBER + 1).boxed().collect(Collectors.toList());

    public static List<Integer> getNumbers() {
        return allNumbers;
    }
}
