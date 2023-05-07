package calculator.domain.operator;

public class Subtraction implements Operator {

    public static final String SUBTRACTION = "-";

    @Override
    public int operate(int a, int b) {
        return a - b;
    }
}
