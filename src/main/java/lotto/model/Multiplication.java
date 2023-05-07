package lotto.model;

public class Multiplication implements Operator {

    public static final String MULTIPLICATION = "*";

    @Override
    public int operate(int a, int b) {
        return a * b;
    }
}
