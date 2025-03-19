package calculator.expression;

public class DivideOperator extends Operator {

    @Override
    public int operate(int left, int right) {
        checkDivideByZero(right);
        checkDivisibility(left, right);
        return left / right;
    }

    private void checkDivideByZero(int right) {
        if (right == 0) {
            throw new ArithmeticException("Division by zero");
        }
    }

    private void checkDivisibility(int left, int right) {
        if (left % right != 0) {
            throw new ArithmeticException("The division does not result in an integer.");
        }
    }
}
