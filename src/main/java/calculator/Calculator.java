package calculator;

import calculator.exception.EmptyValueException;
import calculator.exception.InvalidValueException;

import java.util.*;
import java.util.regex.Pattern;

public class Calculator {
    private static final String DELIMITER = " ";
    private static final String VALIDATION_REGULAR = "\\d+(\\s[\\-*+/]\\s\\d+)*";
    private static final Pattern pattern = Pattern.compile(VALIDATION_REGULAR);

    private Calculator() {

    }

    public static double calculate(String value) {
        validate(value);
        return getAnswer(toQueueString(value));
    }

    private static void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new EmptyValueException();
        }
        if (!isPatternMatched(value)) {
            throw new InvalidValueException();
        }
    }

    private static double getAnswer(Queue<String> q) {
        double answer = Double.parseDouble(q.poll());
        while(!q.isEmpty()) {
            answer = OperatorGroup.findByOperator(q.poll())
                    .calculate(answer, Double.parseDouble(q.poll()));
        }
        return answer;
    }

    private static LinkedList<String> toQueueString(String value) {
        return new LinkedList<>(Arrays.asList(value.split(DELIMITER)));
    }


    private static boolean isPatternMatched(String value) {
        return pattern.matcher(value).matches();
    }
}
