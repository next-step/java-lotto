package domain;

public class Plus implements Operator {
    @Override
    public Number operate(int first, int second) {
        return new Number(first + second);
    }
}
