package lotto.model;

public class Division implements Operator {

    public static final String DIVISION = "/";

    @Override
    public int operate(int a, int b) {
        return a / b;
    }
}
