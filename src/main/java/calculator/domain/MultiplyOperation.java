package calculator.domain;

public class MultiplyOperation implements ArithmeticOperation{
    @Override
    public int compute(int a, int b) {
        return a * b;
    }
}
