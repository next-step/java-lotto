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
            if (i == 0) {
                tempOperand = (Operand) expression.get(i);
                continue;
            }
            if (i % 2 == 1) {
                tempOperator = (Operator) expression.get(i);
                continue;
            }
            int result = calculateOperand(tempOperand, tempOperator, (Operand) expression.get(i));
            tempOperand = new Operand(result);
        }
        return new Number(tempOperand.value());
    }

    private static int calculateOperand(Operand frontOperand, Operator operator, Operand backOperand) {
        return frontOperand.calculate(operator, backOperand);
    }
}
