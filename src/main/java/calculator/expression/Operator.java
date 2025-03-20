package calculator.expression;

public abstract class Operator implements ExpressionComponent {

    @Override
    public int getValue() {
        throw new UnsupportedOperationException("not supported in Operator");
    }
}
