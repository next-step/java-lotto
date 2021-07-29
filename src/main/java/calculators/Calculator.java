package calculators;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public Integer calculate(String input) {
        List<Integer> numbers = splitNumbers(input);
        return numbers.stream().reduce(0, Integer::sum);
    }

    private List<Integer> splitNumbers(String input) {
        String[] split = input.replaceAll(":", ",").split(",");
        return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }
}