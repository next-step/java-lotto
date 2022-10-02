package calculator.operator;

public class DivOperator extends Operator {

    @Override
    public int exec(int first, int second) {
        return first / second;
    }
}
