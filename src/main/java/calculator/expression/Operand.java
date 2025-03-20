package calculator.expression;

public class Operand implements ExpressionComponent {

    private final int value;

    public Operand(String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public int operate(int left, int right) {
        throw new UnsupportedOperationException("not supported in Operand");
    }

    @Override
    public int getValue() {
        return value;
    }
}
