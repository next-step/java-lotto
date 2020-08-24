package stringcalculator.common;

public class ExpressionException extends IllegalArgumentException {
    private ExpressionException(String message) {
        super(message);
    }

    public static void wrongExpression() {
        throw new ExpressionException(ExceptionMessage.WRONG_EXPRESSION.printMessage());
    }

    public static void wrongNumber() {
        throw new ExpressionException(ExceptionMessage.WRONG_NUMBER.printMessage());
    }
}
