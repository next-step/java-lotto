package calculator.domain;

public class Multiplication implements Operator{
    public int operate(int first, int second) {
        return first * second;
    }
}
