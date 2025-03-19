package calculator.expression;

public abstract class ExpressionComponent {

    public abstract int operate(int left, int right);
    public abstract int getValue();
}
