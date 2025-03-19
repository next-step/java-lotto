package calculator.expression;

public class AddOperator extends Operator {

    @Override
    public int operate(int left, int right) {
        return left + right;
    }
}
