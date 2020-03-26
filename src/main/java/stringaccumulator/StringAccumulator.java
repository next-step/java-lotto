package stringaccumulator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Collections.emptyList;

public class StringAccumulator {
    private static final Pattern DEFAULT_DELIMITERS = Pattern.compile(",|:");
    private static final Pattern CUSTOM_DELIMITERS = Pattern.compile("//(.)\n(.*)");
    private static final String NULL_STRING = "";

    private final String expression;

    public StringAccumulator(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public List<String> getSeparateExpression() {
        if (Objects.isNull(expression) || Objects.equals(expression, NULL_STRING)) {
            return emptyList();
        }
        if (DEFAULT_DELIMITERS.matcher(expression).find()) {
            return Arrays.asList(expression.split(DEFAULT_DELIMITERS.pattern()));
        }
        Matcher matcher = CUSTOM_DELIMITERS.matcher(expression);
        if (matcher.find()) {
            return Arrays.asList(matcher.group(2).split(matcher.group(1)));
        }
        
        return Collections.emptyList();
    }

    public int sum(List<String> operands) {
        if (operands.isEmpty()) {
            return 0;
        }

        return operands.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringAccumulator)) return false;
        StringAccumulator that = (StringAccumulator) o;
        return Objects.equals(getExpression(), that.getExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExpression());
    }
}
