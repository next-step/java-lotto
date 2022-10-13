package stringcalculator;

import java.util.Objects;

public class StringCalculator {
    private static final String DELIMITER = " ";

    public Number calculate(String equation) {
        validateNullOrEmpty(equation);

        String[] token = splitEquation(equation);
        Number result = Number.valueOf(token[0]);
        for (int i = 1; i < token.length; i += 2) {
            Operator operator = Operator.of(token[i]);
            Number number = Number.valueOf(token[i + 1]);
            result = operator.calculate(result, number);
        }

        return result;
    }

    private String[] splitEquation(String equation) {
        String[] token = equation.split(DELIMITER);
        validateNumberOfNumberAndOperator(token.length);
        return token;
    }

    private void validateNumberOfNumberAndOperator(int length) {
        if (length % 2 == 0) {
            throw new IllegalArgumentException("잘못된 수식 입니다.");
        }
    }

    private void validateNullOrEmpty(String equation) {
        if (Objects.isNull(equation) || equation.isEmpty()) {
            throw new IllegalArgumentException("공백이나 null은 계산할 수 없습니다.");
        }
    }
}
