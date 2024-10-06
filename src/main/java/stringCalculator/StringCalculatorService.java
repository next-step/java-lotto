package stringCalculator;

import stringCalculator.domain.StringCalculator;

import java.util.List;

public class StringCalculatorService {

    public int calculateExpressions(List<String> expressions) {
        validate(expressions);

        int result = Integer.parseInt(expressions.get(0));
        for (int i = 1; i < expressions.size() - 1; i += 2) {
            String operator = expressions.get(i);
            String secondNumber = expressions.get(i + 1);

            StringCalculator calculator = new StringCalculator(String.valueOf(result), secondNumber, operator);
            result = calculator.calculate();
        }

        return result;
    }

    private static void validate(List<String> expressions) {
        if (expressions.size() < 3 || expressions.size() % 2 == 0) {
            throw new IllegalArgumentException("올바르지 않은 수식 형식입니다.");
        }
    }
}
