package calculator.domain;

import java.util.ArrayList;
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
    private static final List<Number> ZERO_NUMBERS = Collections.singletonList(Number.from(0));

    private final List<Number> values;

    public Numbers(final String expression) {
        if (expression == null || expression.isEmpty()) {
            this.values = ZERO_NUMBERS;
            return;
        }
        this.values = splitFromDelimiter(expression);
    }

    private List<Number> splitFromDelimiter(String expression) {
        expression = convertCustomDelimiterToComma(expression);

        return Arrays.stream(expression.split(REGX_DELIMITER))
            .map(Number::from)
            .collect(Collectors.toList());
    }

    private String convertCustomDelimiterToComma(String expression) {
        Matcher m = PATTERN_REGX_CUSTOM.matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(POSITION_CUSTOM_DELIMITER);
            expression = String.join(COMMA,
                m.group(POSITION_OTHER_EXPRESSION).split(customDelimiter));
        }
        return expression;
    }

    public Number get(int idx) {
        return values.get(idx);
    }

    public List<Number> getValues() {
        return new ArrayList<>(values);
    }
}
