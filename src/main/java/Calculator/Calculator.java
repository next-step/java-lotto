package Calculator;

import static Calculator.ExpressionPreWorker.validateAndSplitExpression;

public class Calculator {

    private Calculator() {
    }

    public static int executeCalc(String exp) {
        return compute(validateAndSplitExpression(exp));
    }

    public static int compute(String[] arr) {
        int i = 0;
        String sum = arr[0];        // op1

        while (i + 2 < arr.length) {
            sum = computeSum(sum, arr[i + 1], arr[i + 2]);
            i += 2;
        }

        return Integer.parseInt(sum);
    }

    private static String computeSum(String op1, String operator, String op2) {
        Operator c = Operator.findOperator(operator);
        return Integer.toString(c.calc(op1, op2));
    }
}
