package calculator;

import java.util.Deque;
import java.util.Stack;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = " ";
    private static final int MIN_CALCULABLE_OPERAND_NUMBER = 2;

    public static Operand calculate(String input){
        Operands operands = new Operands();
        Operators operators = new Operators();
        for (String param : input.split(DEFAULT_DELIMITER)) {
            addCollectionByParamType(operands, operators, param);
            calculate(operands, operators);
        }
        return operands.getOperand();
    }

    private static void calculate(Operands operands, Operators operators) {
        if(!operands.isCalculable()){
            return;
        }
        Operator operator = operators.getOperator();
        operands.add(operator.operation.apply(operands.getOperand(),operands.getOperand()));
    }

    private static void addCollectionByParamType(Operands operands , Operators operators , String param) {
        if (Operator.isOperator(param)){
            operators.add(Operator.getOperator(param));
            return;
        }
        operands.add(new Operand(param));
    }

}
