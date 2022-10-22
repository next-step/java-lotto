package calculator;

public class Multiply implements Operator {
    @Override
    public Number calculate(Number lhs, Number rhs) {
        return lhs.multiply(rhs);
    }
}
