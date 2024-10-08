package calculator;

import java.util.Set;

import static calculator.ErrorMessage.*;

public class Operation {
    private static final Set<String> OPERATION_SET = Set.of("+", "-", "*", "/");
    private static final String ADD_SYMBOL = "+";
    private static final String SUBSTRACT_SYMBOL = "-";
    private static final String MULTIPLY_SYMBOL = "*";
    private static final String DIVIDE_SYMBOL = "/";
    private int num1=0;
    private int num2=0;
    private String symbol="";

    public Operation(String strNum1, String symbol, String strNum2){
        validateOperationSymbol(symbol);
        this.symbol=symbol;
        this.num1=convertStringToInt(strNum1);
        this.num2=convertStringToInt(strNum2);
    }

    public int execute(){
        if(symbol.equals(ADD_SYMBOL)){
            return addNumbers();
        }
        if(symbol.equals(SUBSTRACT_SYMBOL)){
            return subtractNumbers();
        }
        if(symbol.equals(MULTIPLY_SYMBOL)){
            return multiplyNumbers();
        }
        if(symbol.equals(DIVIDE_SYMBOL)){
            return divideNumbers();
        }
        return 0;
    }
    private int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

    private void validateOperationSymbol(String input) {
        if (!OPERATION_SET.contains(input)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_OPERATOR_SYMBOL);
        }
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
