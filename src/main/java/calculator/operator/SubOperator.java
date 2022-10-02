package calculator.operator;

public class SubOperator extends Operator {

    @Override
    public int exec(int first, int second) {
        return first - second;
    }
}
