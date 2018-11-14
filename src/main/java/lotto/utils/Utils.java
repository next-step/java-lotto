package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

    public static final int LOTTO_NUMBER_RANGE_START = 1;
    public static final int LOTTO_NUMBER_RANGE_END = 45;
    public static final int LOTTO_NUMBER_BOUND_START = 0;
    public static final int LOTTO_NUMBER_BOUND_END = 6;

    private Utils() {}

    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END)
                .mapToObj(i -> i)
                .collect(Collectors.toList());

        return shuffle(numbers).subList(LOTTO_NUMBER_BOUND_START, LOTTO_NUMBER_BOUND_END);
    }

    private static List<Integer> shuffle(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }
}
