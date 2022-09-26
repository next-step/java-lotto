package calculator;

import calculator.model.Operand;
import calculator.model.Operands;
import calculator.model.Operator;
import calculator.model.Operators;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = " ";

    public static Operand calculate(String input) {
        Operands operands = new Operands();
        Operators operators = new Operators();
        for (String param : input.split(DEFAULT_DELIMITER)) {
            separateParam(operands, operators, param);
            calculate(operands, operators);
        }
        return operands.getOperand();
    }

    private static void calculate(Operands operands, Operators operators) {
        if (!operands.isCalculable()) {
            return;
        }
        operands.add(operators.getOperator().operation.apply(operands.getOperand(), operands.getOperand()));
    }

    private static void separateParam(Operands operands, Operators operators, String param) {
        if (Operator.isOperator(param)) {
            operators.add(Operator.getOperator(param));
            return;
        }
        operands.add(new Operand(param));
    }
}
