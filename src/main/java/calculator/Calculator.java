package calculator;

import java.util.LinkedList;
import java.util.Queue;

import static calculator.ErrorMessage.*;

public class Calculator {

    private static final String DELIMETER = " ";

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

    public static Queue<String> addArrToQueue(String[] calculateArray) {
        Queue<String> queue = new LinkedList<>();
        for (String str : calculateArray) {
            queue.add(str);
        }
        return queue;
    }


}
