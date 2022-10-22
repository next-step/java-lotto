package calculator;

public class Minus implements Operator {
    @Override
    public int calculate(int lhs, int rhs) {
        return lhs - rhs;
    }
}
