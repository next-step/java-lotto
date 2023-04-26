package calculator.operations;

public class Multiply implements Operator{
    public static final String symbol = "*";

    @Override
    public int apply(int a, int b) {
        return a * b;
    }
}
