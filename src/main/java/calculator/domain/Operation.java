package calculator.domain;


import java.util.Set;

import static calculator.domain.OperationHandler.INPUT_IS_NOT_OPERATOR_SYMBOL;

public class Operation {
    public static final String DIVDE_ZERO_ERROR = "0으로 나눌수 없습니다.";
    private static final Set<String> OPERATION_SET = Set.of("+", "-", "*", "/");
    private static final String ADD_SYMBOL = "+";
    private static final String SUBSTRACT_SYMBOL = "-";
    private static final String MULTIPLY_SYMBOL = "*";
    private static final String DIVIDE_SYMBOL = "/";
    private final int num1;
    private final int num2;
    private final String symbol;

    public Operation(int num1, String symbol, int num2) {
        this.symbol = validateOperationSymbol(symbol);
        this.num1 = num1;
        this.num2 = num2;
    }

    private String validateOperationSymbol(String input) {
        if (!OPERATION_SET.contains(input)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_OPERATOR_SYMBOL);
        }
        return input;
    }

    public int execute() {
        if (symbol.equals(ADD_SYMBOL)) {
            return addNumbers();
        }
        if (symbol.equals(SUBSTRACT_SYMBOL)) {
            return subtractNumbers();
        }
        if (symbol.equals(MULTIPLY_SYMBOL)) {
            return multiplyNumbers();
        }
        if (symbol.equals(DIVIDE_SYMBOL)) {
            return divideNumbers();
        }
        throw new IllegalArgumentException(INPUT_IS_NOT_OPERATOR_SYMBOL);
    }

    private int addNumbers() {
        return num1 + num2;
    }

    private int subtractNumbers() {
        return num1 - num2;
    }

    private int multiplyNumbers() {
        return num1 * num2;
    }

    private int divideNumbers() {
        if (num2 == 0) {
            throw new IllegalArgumentException(DIVDE_ZERO_ERROR);
        }
        return num1 / num2;
    }
}
