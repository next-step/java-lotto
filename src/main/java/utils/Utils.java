package utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

    private static final int LOTTO_NUMBER_RANGE_START = 1;
    private static final int LOTTO_NUMBER_RANGE_END = 45;
    private static final int LOTTO_NUMBER_BOUND_START = 0;
    private static final int LOTTO_NUMBER_BOUND_END = 6;

    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END)
                .mapToObj(i-> i)
                .collect(Collectors.toList());

        return shuffle(numbers).subList(LOTTO_NUMBER_BOUND_START, LOTTO_NUMBER_BOUND_END);
    }

    public static List<Integer> shuffle(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }

}
