package calculator;

import java.util.Set;

import static calculator.ErrorMessage.*;

public class Operation {
    private static final String ADD_SYMBOL = "+";
    private static final String SUBSTRACT_SYMBOL = "-";
    private static final String MULTIPLY_SYMBOL = "*";
    private static final String DIVIDE_SYMBOL = "/";
    private int num1 = 0;
    private int num2 = 0;
    private String symbol = "";

    public Operation(int num1, String symbol, int num2) {
        this.symbol = symbol;
        this.num1 = num1;
        this.num2 = num2;
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
        return 0;
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
