package domain;

import java.util.List;

public class StringAdder {

    public int adder(List<Integer> numbers) {
        if (isBlank(numbers)) {
            return 0;
        }
        return sum(numbers);
    }

    public static int sum(List<Integer> inputNumber) {
        return inputNumber
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static boolean isBlank(List<Integer> input) {
        return input.isEmpty();
    }
}
