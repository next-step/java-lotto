package study.lotto.step1.application;

import study.lotto.step1.domain.*;


public class StringCalculator {
    private StringCalculator() {
    }

    public static String calculate(String expression) {
        Operands operands = ExpressionParser.operands(expression);
        Operators operators = ExpressionParser.operators(expression);
        validateOperandsAndOperators(operands, operators);

        while(operators.hasNext()) {
            OperationResult calculated = operation(operands, operators).calculate();
            operands.addFirst(calculated.operand());
        }

        return operands.removeFirst().plainString();
    }

    private static Operation operation(Operands operands, Operators operators) {
        return new Operation(operands.removeFirst(), operands.removeFirst(), operators.removeFirst());
    }

    private static void validateOperandsAndOperators(Operands operands, Operators operators) {
        if(operands.size() != operators.size() + 1) {
            throw new IllegalArgumentException("연산자의 갯수는 피연산자의 갯수보다 하나 많아야 합니다. 연산자 수: "
                    + operators.size() + ", 피연산자 수: " + operands.size());
        }
    }
}
