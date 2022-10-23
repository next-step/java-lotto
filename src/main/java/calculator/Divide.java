package calculator;

public class Divide implements Operator {
    @Override
    public Number calculate(Number lhs, Number rhs) {
        return lhs.divide(rhs);
    }
}
