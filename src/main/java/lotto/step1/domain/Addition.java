package lotto.step1.domain;

public class Addition implements MathOperation {

    @Override
    public int calc(int a, int b) {
        return a + b;
    }
}
