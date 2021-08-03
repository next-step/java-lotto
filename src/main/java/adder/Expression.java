package adder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Expression {

    public static final String NON_NULL = "입력값은 null 일 수 없습니다";
    private static final String ZERO_STRING = "0";

    private final String expression;

    public Expression(String input) {
        this.expression = getOrZero(input);
    }

    public Matcher getMatchers(Pattern pattern) {
        validatePattern(pattern);
        return pattern.matcher(expression);
    }

    public List<String> split(String delimiterPattern) {
        validateDelimiterPattern(delimiterPattern);
        return Arrays.stream(expression.split(delimiterPattern))
                .collect(Collectors.toList());
    }

    private void validatePattern(Pattern pattern) {
        if (Objects.isNull(pattern)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }

    private void validateDelimiterPattern(String delimiterPattern) {
        if (Objects.isNull(delimiterPattern)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }

    private String getOrZero(String input) {
        return isBlank(input)
                ? ZERO_STRING
                : input;
    }

    private boolean isBlank(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }
}
