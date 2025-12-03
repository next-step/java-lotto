package domain;

public class Multiplication implements Operator {
    @Override
    public Number operate(Number first, Number second) {
        return first.multiply(second);
    }
}
