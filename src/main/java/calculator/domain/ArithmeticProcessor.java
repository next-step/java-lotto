package calculator.domain;

public class ArithmeticProcessor {

    public static int processExpression(String[] expression) {
        int result = Integer.parseInt(expression[0]);

        for (int i = 1; i < expression.length; i += 2) {
            result = OperatorMaster.calculate(expression[i], result, Integer.parseInt(expression[i + 1]));
        }

        return result;
    }
}
