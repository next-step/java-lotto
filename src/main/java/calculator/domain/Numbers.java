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
    private static final List<Number> ZERO_NUMBERS = Collections.singletonList(new Number(0));

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
            String customDelimiter = m.group(POSITION_CUSTOM_DELIMITER);
            return splitDelimiter(m.group(POSITION_OTHER_EXPRESSION).split(customDelimiter));
        }

        return Arrays.stream(expression.split(REGX_DELIMITER))
            .map(Number::new)
            .collect(Collectors.toList());
    }

    private List<Number> splitDelimiter(String[] expression) {
        String join = String.join(COMMA, expression);
        String[] split = join.split(REGX_DELIMITER);
        return Arrays.stream(split)
            .map(Number::new)
            .collect(Collectors.toList());
    }

    public Number get(int idx) {
        return numbers.get(idx);
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
