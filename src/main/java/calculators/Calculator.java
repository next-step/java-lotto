package calculators;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    private final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public Integer calculate(String input) {
        List<Integer> numbers = splitNumbers(input);
        return numbers.stream().reduce(0, Integer::sum);
    }

    private List<Integer> splitNumbers(String input) {
        String separator = ":";

        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            separator = matcher.group(1);
            input = matcher.group(2);
        }
        input = input.replaceAll(separator, ",");
        String[] split = input.split(",");
        return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }
}
