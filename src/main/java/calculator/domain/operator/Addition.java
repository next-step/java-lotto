package calculator.domain.operator;

public class Addition implements Operator {

    public static final String ADDICTION = "+";

    @Override
    public int operate(int a, int b) {
        return a + b;
    }
}
