package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorHelper {
    static final String REGEX = "//(.)\\\\n(.*)";

    static List<String> findNumber(String expression) {
        if (Objects.isNull(expression) || expression.trim().isEmpty())
            return new ArrayList<>();

        Matcher matcher = Pattern.compile(REGEX).matcher(expression);

        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String[] numbers = matcher.group(2).split(delimiter);

            return Arrays.asList(numbers);
        }

        return Arrays.asList(expression.split(",|:"));
    }
}
