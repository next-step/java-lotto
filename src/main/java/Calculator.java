public class Calculator {
    public int calculate(Expression expression) {
        int operatorSize = expression.getOperatorSize();
        int sum = expression.getCurrentNumber();
        for (int index = 0; index < operatorSize; index++) {
            Operator operator = expression.getCurrentOperator();
            int rightOperand = expression.getCurrentNumber();
            sum = operator.calculate(sum, rightOperand);
        }
        return sum;
    }

    private int calculate(int a, int b, Operator operator) {
        return operator.calculate(a, b);
    }
}
