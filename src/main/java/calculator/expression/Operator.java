package calculator.expression;

public abstract class Operator extends ExpressionComponent{

    @Override
    public int getValue() {
        throw new UnsupportedOperationException("not supported in Operator");
    }
}
