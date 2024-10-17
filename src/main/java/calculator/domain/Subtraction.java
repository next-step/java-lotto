package calculator.domain;

public class Subtraction implements Operation {
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
