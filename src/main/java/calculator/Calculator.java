package calculator;

import calculator.exception.CalculatorErrorCode;
import exception.CustomException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private static final String REGEX = " ";

    public static int splitAndCalculate(String str) {
        if (isBlank(str)) {
            throw new CustomException(CalculatorErrorCode.INPUT_VALUE_NULL_POINT_ERROR);
        }
        return calculate(toList(str.split(REGEX)));
    }

    private static List<String> toList(String[] arr) {
        return Arrays.asList(arr);
    }

    private static int calculate(List<String> calculateStrings) {
        int result = Integer.parseInt(calculateStrings.get(0));
        for (int i = 1; i < calculateStrings.size(); i++) {
            Operation operation = Operation.valueOfSymbol(calculateStrings.get(i));
            int number = Integer.parseInt(calculateStrings.get(++i));
            result = operation.apply(result, number);
        }
        return result;
    }

    private static boolean isBlank(String str) {
        return str == null || str.equals("");
    }
}
