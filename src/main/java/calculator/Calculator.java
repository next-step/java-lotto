package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static calculator.ErrorMessage.*;
import static calculator.InputView.inputStr;

public class Calculator {
    private static final String DELIMETER = " ";
    public static void StartCalculate(){
        String[] inputArrays= splitInput(inputStr());
        OperationHandler operationHandler = new OperationHandler(inputArrays);
        operationHandler.calculate();
    }

    public static String[] splitInput(String input) {
        validateString(input);
        return input.split(DELIMETER);
    }

    private static void validateString(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(BLINK_INPUT_ERROR);
        }
    }

    private static boolean isBlank(String input) {
        return (input == null || input.trim().isEmpty());
    }

}
