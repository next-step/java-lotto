package calculator;

import static calculator.ErrorMessage.BLINK_INPUT_ERROR;

public class Calculator {
    public static void validateString(String input){
        if(isBlank(input)){
            throw new IllegalArgumentException(BLINK_INPUT_ERROR);
        }
    }

    private static boolean isBlank(String input) {
        return (input == null || input.trim().isEmpty());
    }
}
