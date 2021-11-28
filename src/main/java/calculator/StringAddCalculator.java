package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return split(input).stream()
                .reduce(0, Integer::sum);
    }

    static List<Integer> split(String input) {
        return Arrays.stream(input.split("[,:]"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
