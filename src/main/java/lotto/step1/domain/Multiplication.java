package lotto.step1.domain;

public class Multiplication implements MathOperation{
    @Override
    public int calc(int a, int b) {
        return a * b;
    }
}
