package calculator.operator;

public class AddOperator extends Operator {

    @Override
    public int exec(int first, int second) {
        return first + second;
    }
}
