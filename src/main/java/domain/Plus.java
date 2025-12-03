package domain;

public class Plus implements Operator {
    @Override
    public Number operate(Number first, Number second) {
        return first.plus(second);
    }
}
