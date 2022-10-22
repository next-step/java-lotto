package calculator;

public class Divide implements Operator {
    @Override
    public int calculate(int lhs, int rhs) {
        return lhs / rhs;
    }
}
