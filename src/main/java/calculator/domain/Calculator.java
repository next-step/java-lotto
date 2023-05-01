package calculator.domain;

public class Calculator {

    public static Number calculate(Expression expression) {
        Operand tempOperand = null;
        Operator tempOperator = null;
        for (int i = 0; i < expression.size(); i++) {
            ExpressionElement expressionElement = expression.get(i);
            if (i == 0) {
                tempOperand = convertToOperand(expressionElement);
                continue;
            }
            if (i % 2 == 1) {
                tempOperator = convertToOperator(expressionElement);
                continue;
            }
            Number result = calculate(tempOperand, tempOperator, convertToOperand(expressionElement));
            tempOperand = new Operand(result.value());
        }
        return new Number(tempOperand.value());
    }

    private static Operand convertToOperand(ExpressionElement expressionElement) {
        return (Operand) expressionElement;
    }

    private static Operator convertToOperator(ExpressionElement expressionElement) {
        return (Operator) expressionElement;
    }

    private static Number calculate(Operand preOperand, Operator operator, Operand postOperand) {
        return operator.calculate(preOperand, postOperand);
    }
}
