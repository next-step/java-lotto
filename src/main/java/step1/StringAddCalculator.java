package step1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {
    public static final String DELIMITER = "[,:]";

    public static int splitAndSum(String s) {
        String[] splitedStrings = s.split(DELIMITER);
        List<Integer> parsedNumbers = Arrays.stream(splitedStrings)
                .map(StringAddCalculator::parseInt)
                .collect(Collectors.toList());

        return parsedNumbers.stream().reduce(0, (acc, cur) -> acc += cur);
    }

    public static int parseInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new RuntimeException(String.format("Passed wrong formatted string %s", target), e);
        }
    }
}
