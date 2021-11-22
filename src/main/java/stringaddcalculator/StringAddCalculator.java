package stringaddcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static final Pattern DELIMETER_PATTERN = Pattern.compile("//(?<delimeter>.)\n");
    private static final String DEFAULT_DELIMETER = ",|:";

    public static int splitAndSum(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0;
        }
        Matcher matcher = DELIMETER_PATTERN.matcher(value);

        String delimeter = null;
        String expression = value;

        while (matcher.find()) {
            delimeter = matcher.group("delimeter");
            expression = matcher.replaceFirst("");
        }
        if (delimeter == null) {
            delimeter = DEFAULT_DELIMETER;
        }

        List<Integer> numbers = Arrays.stream(expression.split(delimeter))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        return numbers.stream().reduce(0 ,(a, b) -> {
            if (b < 0) {
                throw new RuntimeException("음수는 입력할 수 없습니다.");
            }
            return a + b;
        });
    }
}


