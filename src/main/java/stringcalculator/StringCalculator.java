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
            throw new CaculateException(ErrorCode.WRONG_EQUATION_FORMAT);
        }
    }

    private void validateNullOrEmpty(String equation) {
        if (Objects.isNull(equation) || equation.isEmpty()) {
            throw new CaculateException(ErrorCode.CALCULATE_NULL);
        }
    }
}
