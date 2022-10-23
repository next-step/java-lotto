package calculator;

import static calculator.Separator.parser;

public class Calculator {
    public int calculate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

        if (input.length() % 2 == 0 || input.length() == 1) {
            throw new IllegalArgumentException("수식을 확인해주세요");
        }

        return getResult(parser(input));
    }

    private int getResult(String[] splitExpression) {
        int result = Integer.parseInt(splitExpression[0]);

        for (int i = 1; i < splitExpression.length; i++) {
            result = Operator.findOperator(splitExpression[i])
                    .calculate(result, Integer.parseInt(splitExpression[++i]));
        }
        return result;
    }
}
