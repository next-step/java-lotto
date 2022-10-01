package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {

    private static final String EMPTY_STRING = " ";

    private final String expression;

    public Expression(final String expression) {

        validateNullOrEmpty(expression);
        this.expression = expression;
    }

    private void validateNullOrEmpty(final String expression) {

        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 또는 빈 공백 입니다.");
        }
    }

    public List<String> split() {

        return Arrays.stream(this.expression.split(EMPTY_STRING))
                .collect(Collectors.toList());
    }
}
