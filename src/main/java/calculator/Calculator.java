package calculator;

public class Calculator {
    public int calculate(String input) {
        if (input.isBlank() || input.length() % 2 == 0 || input.length() == 1) {
            throw new IllegalArgumentException("값을 입력해주세요");
        }

        String[] splitExpression = input.split(" ");
        int result = Integer.parseInt(splitExpression[0]);

        for (int i = 1; i < splitExpression.length; i++) {
            result = Operator.findOperator(splitExpression[i])
                    .calculate(result, Integer.parseInt(splitExpression[++i].trim()));
        }
        return result;
    }
}
