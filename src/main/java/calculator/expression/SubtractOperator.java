package calculator.expression;

public class SubtractOperator extends Operator {

    @Override
    public int operate(int left, int right) {
        return left - right;
    }
}
