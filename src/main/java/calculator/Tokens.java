package calculator;

import java.util.List;

public class Tokens {
    private static final String DELIMITER = " ";

    private final List<String> values;

    private Tokens(List<String> values) {
        validate(values);
        this.values = values;
    }

    static Tokens from(String text) {
        InputExpression expression = new InputExpression(text);
        List<String> values = expression.splitBy(DELIMITER);
        return new Tokens(values);
    }

    PositiveNumber value() {
        PositiveNumber result = firstNumber();
        for (int i = 1; i < values.size(); i += 2) {
            result = calculate(result, i);
        }
        return result;
    }

    private void validate(List<String> values) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("토큰이 비어 있습니다.");
        }
        if (values.size() % 2 == 0) {
            throw new IllegalArgumentException("잘못된 수식 형식입니다.");
        }
    }

    private PositiveNumber firstNumber() {
        String first = values.get(0);
        return PositiveNumber.from(first);
    }

    private PositiveNumber calculate(PositiveNumber left, int operatorIndex) {
        String operatorToken = values.get(operatorIndex);
        String rightToken = values.get(operatorIndex + 1);

        Operator operator = Operator.from(operatorToken);
        PositiveNumber right = PositiveNumber.from(rightToken);

        return operator.apply(left, right);
    }
}
