package lotto.numbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllNumbers {
    private static final int LAST_NUMBER = 45;

    private static List<Integer> allNumbers;

    public static List<Integer> getNumbers() {
        if(allNumbers == null || allNumbers.isEmpty()) {
            allNumbers = IntStream.range(1, LAST_NUMBER + 1).boxed().collect(Collectors.toList());
        }
        return allNumbers;
    }
}
