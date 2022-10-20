package calculator.operator;

public class MultiplyOperator implements Operator {
    @Override
    public int applyAsInt(int left, int right) {
        return left * right;
    }
}
