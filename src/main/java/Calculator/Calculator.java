package Calculator;

import static Calculator.ExpressionPreWorker.validateAndSplitExpression;

public class Calculator {

    private Calculator() {
    }

    public static int executeCalc(String exp) {
        return compute(validateAndSplitExpression(exp));
    }

    private static int compute(String[] arr) {
        int i = 0;
        int sum = Integer.parseInt(arr[0]);        // op1

        while (i + 2 < arr.length) {
            int op2 = Integer.parseInt(arr[i + 2]);
            sum = computeSum(sum, arr[i + 1], op2);
            i += 2;
        }

        return sum;
    }

    private static int computeSum(int op1, String operator, int op2) {
        Operator op = Operator.findOperator(operator);
        return op.calc(op1, op2);
    }
}
