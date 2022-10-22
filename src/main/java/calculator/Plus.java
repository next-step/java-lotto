package calculator;

public class Plus implements Operator {
    @Override
    public Number calculate(Number lhs, Number rhs) {
        return lhs.plus(rhs);
    }
}
