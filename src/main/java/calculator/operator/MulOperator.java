package calculator.operator;

public class MulOperator extends Operator {

    @Override
    public int exec(int first, int second) {
        return first * second;
    }
}
