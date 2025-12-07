package domain;

public class Division implements Operator {
    @Override
    public Number operate(int first, int second) {
        return new Number(first / second);
    }
}
