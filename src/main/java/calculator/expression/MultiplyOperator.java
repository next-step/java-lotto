package calculator.expression;

public class MultiplyOperator extends Operator {

    @Override
    public int operate(int left, int right) {
        return left * right;
    }
}
