package calculator;

public class Minus implements Operator {
    @Override
    public Number calculate(Number lhs, Number rhs) {
        return lhs.minus(rhs);
    }
}
