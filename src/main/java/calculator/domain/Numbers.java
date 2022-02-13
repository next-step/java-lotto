package calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {

    private static final String REGX_DELIMITER = ",|:";
    private static final String REGX_CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern PATTERN_REGX_CUSTOM = Pattern.compile(REGX_CUSTOM_DELIMITER);
    private static final int POSITION_CUSTOM_DELIMITER = 1;
    private static final int POSITION_OTHER_EXPRESSION = 2;
    private static final String COMMA = ",";
    private static final Number ZERO = new Number(0);
    private static final List<Number> ZERO_NUMBERS = Collections.singletonList(ZERO);

    private final List<Number> numbers;

    public Numbers(final String expression) {
        if (expression == null || expression.isEmpty()) {
            this.numbers = ZERO_NUMBERS;
            return;
        }
        this.numbers = splitFromDelimiter(expression);
    }

    private List<Number> splitFromDelimiter(String expression) {
        Matcher m = PATTERN_REGX_CUSTOM.matcher(expression);
        if (m.find()) {
            final String customDelimiter = m.group(POSITION_CUSTOM_DELIMITER);
            final String[] numbers = m.group(POSITION_OTHER_EXPRESSION).split(customDelimiter);
            final String[] splittedNumber = String.join(COMMA, numbers).split(REGX_DELIMITER);
            return Arrays.stream(splittedNumber)
                    .map(Number::new)
                    .collect(Collectors.toList());
        }

        return Arrays.stream(expression.split(REGX_DELIMITER))
            .map(Number::new)
            .collect(Collectors.toList());
    }

    public Number get(int index) {
        return numbers.get(index);
    }

    public Number addAll() {
        return numbers.stream()
            .reduce(ZERO, Number::add);
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
