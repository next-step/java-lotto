package calculator;

import java.util.List;

public class Calculator {

    private int result = 0;

    public int calculate(String expression) {
        ExpressionParser parser = new ExpressionParser(expression);
        List<Operator> operators = parser.getOperators();
        List<Operand> operands = parser.getOperands();

        for (int i = 0; i < operators.size(); i++) {
            Operand operate = operators.get(i).operate(operands.get(i), operands.get(i + 1));
            result += operate.getValue();
        }
        return result;
    }

}
