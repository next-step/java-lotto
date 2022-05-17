package calculator.domain;

public class SubstractOperation implements ArithmeticOperation{
    @Override
    public int compute(int a, int b) {
        return a - b;
    }
}
