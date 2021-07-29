package calculators;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private final String PREFIX = "//";
    private final String SUFFIX = "\n";

    public Integer calculate(String input) {
        List<Integer> numbers = splitNumbers(input);
        return numbers.stream().reduce(0, Integer::sum);
    }

    private List<Integer> splitNumbers(String input) {
        String separator = ":";

        if (input.startsWith(PREFIX) && input.contains(SUFFIX)) {
            int start = input.indexOf(PREFIX);
            int end = input.indexOf(SUFFIX);
            separator = input.substring(start + 2, end);
            input = input.substring(end + 1);
        }
        input = input.replaceAll(separator, ",");
        String[] split = input.split(",");
        return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }
}
