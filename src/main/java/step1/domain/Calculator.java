package step1.domain;

public class Calculator {

    public int calculateResult(String[] parsedExpression) {
        int result = Integer.parseInt(parsedExpression[0]);

        for (int i = 1; i < parsedExpression.length; i += 2) {
            result = Operator.findOperator(parsedExpression[i])
                    .calculate(result, Integer.parseInt(parsedExpression[i + 1]));
        }
        return result;
    }
}
