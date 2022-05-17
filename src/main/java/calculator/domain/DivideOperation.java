package calculator.domain;

public class DivideOperation implements ArithmeticOperation{
    @Override
    public int compute(int a, int b) {
        return a / b;
    }
}
