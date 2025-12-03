package domain;

public class Division implements Operator {
    @Override
    public Number operate(Number first, Number second) {
        return first.divide(second);
    }
}
