package calculator.domain;

/**
 * @author : 0giri
 * @since : 2023/04/25
 */
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
            int result = calculateOperand(tempOperand, tempOperator, convertToOperand(expressionElement));
            tempOperand = new Operand(result);
        }
        return new Number(tempOperand.value());
    }

    private static Operand convertToOperand(ExpressionElement expressionElement) {
        return (Operand) expressionElement;
    }

    private static Operator convertToOperator(ExpressionElement expressionElement) {
        return (Operator) expressionElement;
    }

    private static int calculateOperand(Operand frontOperand, Operator operator, Operand backOperand) {
        return frontOperand.calculate(operator, backOperand);
    }
}
