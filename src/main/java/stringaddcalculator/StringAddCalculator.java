package stringaddcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {
    public static int splitAndSum(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0;
        }
        List<Integer> numbers = Arrays.stream(value.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        return numbers.stream().reduce(0 ,Integer::sum);
    }
}


