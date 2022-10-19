package calculator;

import calculator.exception.CalculatorErrorCode;
import exception.CustomException;

public class Calculator {

    private static final String REGEX = " ";

    public static int splitAndCalculate(String str) {
        if (isBlank(str)) {
            throw new CustomException(CalculatorErrorCode.INPUT_VALUE_NULL_POINT_ERROR);
        }
        return calculate(str.split(REGEX));
    }

    private static int calculate(String[] calculateStrings) {
        int result = Integer.parseInt(calculateStrings[0]);
        for (int i = 1; i < calculateStrings.length; i++) {
            Operation operation = Operation.valueOfSymbol(calculateStrings[i]);
            int number = Integer.parseInt(calculateStrings[++i]);
            result = operation.apply(result, number);
        }
        return result;
    }

    private static boolean isBlank(String str) {
        return str == null || str.equals("");
    }
}
