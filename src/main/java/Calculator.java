public class Calculator {
    public int calculate(Expression expression) {
        int operatorSize = expression.getOperatorSize();
        int sum = calculate(expression.getCurrentNumber(0), expression.getCurrentNumber(1), expression.getCurrentOperator(0));
        for (int index = 1; index < operatorSize; index++) {
            Operator operator = expression.getCurrentOperator(index);
            sum = operator.calculate(sum, expression.getCurrentNumber(index+1));
        }
        return sum;
    }

    private int calculate(int a, int b, Operator operator) {
        return operator.calculate(a, b);
    }
}
