package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {

    public static final String CRITERIA = " ";
    private final String value;

    public Expression(String value) {
        validateExpression(value);
        this.value = value;
    }

    public List<String> parseToList() {
        return Arrays.stream(value.split(CRITERIA))
                .collect(Collectors.toList());
    }

    private void validateExpression(String value) {
        validateNull(value);
        validateBlank(value);
    }

    private void validateNull(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
    }

    private void validateBlank(String expression) {
        if (expression.isBlank()) {
            throw new IllegalArgumentException("입력값이 공백입니다.");
        }
    }
}
