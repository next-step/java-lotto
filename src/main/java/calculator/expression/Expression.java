package calculator.expression;

public interface Expression {

    NumberExpression calc();

    static Expression createOperation(String operation, Expression before, NumberExpression numberExpression) {
        if (PlusExpression.isSupport(operation)) {
            return new PlusExpression(before, numberExpression);
        }
        if (SubtractExpression.isSupport(operation)) {
            return new SubtractExpression(before, numberExpression);
        }
        if (MultiplyExpression.isSupport(operation)) {
            return new MultiplyExpression(before, numberExpression);
        }
        if (DivideExpression.isSupport(operation)) {
            return new DivideExpression(before, numberExpression);
        }
        return null;
    }
}
