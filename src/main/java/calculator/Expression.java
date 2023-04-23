package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {

    public static final String CRITERIA = " ";
    public static final String REGEX = "^(-?\\d+|[+\\-*/])$";
    private final String value;

    public Expression(String value) {
        validateExpression(value);
        this.value = value;
    }

    public List<String> parseToList() {
        List<String> elements = Arrays.stream(value.split(CRITERIA))
                .collect(Collectors.toList());

        validateElements(elements);
        return elements;
    }

    private void validateElements(List<String> elements) {
        for (String element : elements) {
            validateEachElement(element);
        }
    }

    private void validateEachElement(String element) {
        if (!element.matches(REGEX)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
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
