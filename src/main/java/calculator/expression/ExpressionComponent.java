package calculator.expression;

public interface ExpressionComponent {
    int operate(int left, int right);
    int getValue();
}
