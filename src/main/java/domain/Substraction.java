package domain;

public class Substraction implements Operator {
    public Number operate(int first, int second) {
        return new Number(first - second);
    }
}
