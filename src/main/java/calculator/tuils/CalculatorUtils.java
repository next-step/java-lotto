package calculator.tuils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorUtils {
    private static final Pattern PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final String REGEX = ",|:";

    public static List<String> findNumber(String expression) {
        if (Objects.isNull(expression) || expression.trim().isEmpty())
            return new ArrayList<>();

        Matcher matcher = PATTERN.matcher(expression);

        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String[] numbers = matcher.group(2).split(delimiter);

            return Arrays.asList(numbers);
        }

        return Arrays.asList(expression.split(REGEX));
    }
}
