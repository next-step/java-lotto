package domain;

public class Multiplication implements Operator {
    @Override
    public Number operate(int first, int second) {
        return new Number(first * second);
    }
}
