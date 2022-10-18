package calculator.operator;

public class DivideOperator implements Operator {
    @Override
    public int applyAsInt(int left, int right) {
        return left / right;
    }
}
