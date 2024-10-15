package calculator.domain;

public class Division implements Operation {
    @Override
    public int calculate(int a, int b) {
        return a / b;
    }
}
