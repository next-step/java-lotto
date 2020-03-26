package stringaccumulator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;

public class StringAccumulator {
    private static final String DEFAULT_DELIMITERS = ",|:";
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
        return Arrays.asList(expression.split(DEFAULT_DELIMITERS));
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
