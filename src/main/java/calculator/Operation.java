package calculator;

import java.util.List;

public class Operation {
    private static final String SYMBOL_OF_ADD = "+";
    private static final String SYMBOL_OF_SUBTRACT = "-";
    private static final String SYMBOL_OF_MULTIPLY = "*";
    private static final String SYMBOL_OF_DIVISION = "/";
    private static final int NEVER_RETURN_VALUE = 0;

    private Operation() {
        throw new IllegalStateException("Util Class");
    }

    public static int run(String operator, int operand, int operand2) {
        validateOperator(operator);

        if (operator.equals(SYMBOL_OF_ADD)) {
            return operand + operand2;
        }

        if(operator.equals(SYMBOL_OF_SUBTRACT)) {
            return operand - operand2;
        }

        if(operator.equals(SYMBOL_OF_DIVISION)) {
            validateCanDivision(operand2);
            return operand / operand2;
        }

        if(operator.equals(SYMBOL_OF_MULTIPLY)) {
            return operand * operand2;
        }

        return NEVER_RETURN_VALUE;
    }

    private static void validateCanDivision(int operand2) {
        if(operand2 == 0) {
            throw new IllegalStateException("0으로 나눌 수 없습니다.");
        }
    }

    private static void validateOperator(String operator) {
        if (!isOperators(operator)) {
            throw new IllegalStateException("정의되지 않은 연산자가 입력 되었습니다.");
        }
    }

    private static boolean isOperators(String operator) {
        return List.of(SYMBOL_OF_ADD, SYMBOL_OF_SUBTRACT, SYMBOL_OF_MULTIPLY, SYMBOL_OF_DIVISION).contains(operator);
    }

}
