package stringCalculator;

import stringCalculator.domain.ArithmeticOperator;
import stringCalculator.domain.Number;

import java.util.Arrays;
import java.util.List;

public class StringCalculatorService {

    private static final String EXPRESSION_DELIMITER = " ";

    public int calculateExpressions(String expression) {
        List<String> expressions = getExpressions(expression);
        validate(expressions);

        int result = new Number(expressions.get(0)).getNumber();
        for (int i = 1; i < expressions.size() - 1; i += 2) {
            String operator = expressions.get(i);
            Number secondNumber = new Number(expressions.get(i + 1));

            ArithmeticOperator arithmeticOperator = ArithmeticOperator.from(operator);
            result = arithmeticOperator.calculate(result, secondNumber.getNumber());
        }

        return result;
    }

    private static List<String> getExpressions(String expression) {
        return Arrays.asList(expression.split(EXPRESSION_DELIMITER));
    }

    private static void validate(List<String> expressions) {
        if (expressions.size() < 3 || expressions.size() % 2 == 0) {
            throw new IllegalArgumentException("올바르지 않은 수식 형식입니다.");
        }
    }
}
