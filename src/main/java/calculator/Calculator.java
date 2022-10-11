package calculator;

import java.util.List;

public class Calculator {

    private int result = 0;

    public int calculate(String expression) {
        ExpressionParser parser = new ExpressionParser(expression);
        List<Operator> operators = parser.getOperators();
        List<Operand> operands = parser.getOperands();

        for (int token = 0; token < operators.size(); token++) {
            Operand operate = operators.get(token).operate(operands.get(token), operands.get(token + 1));
            result += operate.getValue();
        }
        return result;
    }

}
