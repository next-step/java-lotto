package step1.domain;

public class Calculator {

    public int calculate(Expression expression) {
        Operands operands = expression.generateOperands();
        Operators operators = expression.generateOperators();

        int result = operands.get(0).getOperand();
        for (int i = 0; i < operators.size(); i++) {
            int right = operands.get(i + 1).getOperand();
            Operator operator = operators.get(i);
            result = operator.calculate(result, right);
        }
        return result;
    }
}
