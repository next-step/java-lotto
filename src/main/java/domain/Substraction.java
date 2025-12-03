package domain;

public class Substraction implements Operator {
    public Number operate(Number first, Number second) {
        return first.substract(second);
    }
}
