package stringaccumulator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Collections.emptyList;

public class StringAccumulator {
    private static final Pattern DEFAULT_DELIMITERS = Pattern.compile(",|:");
    private static final Pattern CUSTOM_DELIMITERS = Pattern.compile("//(.)\n(.*)");
    private static final String NULL_STRING = "";

    private final Operands operands;

    public StringAccumulator(String expression) {
        this.operands = separateExpression(expression);
    }

    public String getExpression() {
        return operands.toString();
    }

    public int sum() {
        return operands.sum();
    }

    private Operands separateExpression(String expression) {
        if (Objects.isNull(expression) || Objects.equals(expression, NULL_STRING)) {
            return new Operands(emptyList());
        }
        if (DEFAULT_DELIMITERS.matcher(expression).find()) {
            return new Operands(Arrays.asList(expression.split(DEFAULT_DELIMITERS.pattern())));
        }
        Matcher matcher = CUSTOM_DELIMITERS.matcher(expression);
        if (matcher.find()) {
            return new Operands(Arrays.asList(matcher.group(2).split(matcher.group(1))));
        }

        return new Operands(Arrays.asList(expression));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringAccumulator)) return false;
        StringAccumulator that = (StringAccumulator) o;
        return Objects.equals(operands, that.operands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands);
    }
}
