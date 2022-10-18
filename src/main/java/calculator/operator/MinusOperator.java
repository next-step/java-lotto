package calculator.operator;

public class MinusOperator implements Operator {
    @Override
    public int applyAsInt(int left, int right) {
        return left - right;
    }
}
