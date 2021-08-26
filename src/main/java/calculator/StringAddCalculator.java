package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public StringAddCalculator() {
    }

    public int splitAndSum(String input) {
        if (isNullOrBlank(input)) {
            return 0;
        }
        return sumValues(splitInput(input));
    }

    private String[] splitInput(String input) {
        Matcher m = Pattern.compile("//(.)\\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(",|:");
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    private int sumValues(String[] input) {
        return Arrays.stream(input)
            .mapToInt(Integer::parseInt)
            .sum();
    }

}
