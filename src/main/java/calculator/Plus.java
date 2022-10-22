package calculator;

public class Plus implements Operator {
    @Override
    public int calculate(int lhs, int rhs) {
        return lhs + rhs;
    }
}
