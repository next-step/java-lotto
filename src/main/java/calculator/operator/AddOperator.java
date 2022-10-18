package calculator.operator;

public class AddOperator implements Operator {
    @Override
    public int applyAsInt(int left, int right) {
        return left + right;
    }
}
