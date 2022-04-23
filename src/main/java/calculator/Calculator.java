package calculator;

import calculator.exception.EmptyValueException;
import calculator.exception.InvalidValueException;

import java.util.*;

public class Calculator {
    public static final String DELIMITER = " ";
    private static final String VALIDATION_REGULAR = "^[+\\-*/\\d\\s]*$";


    public static double calculate(String value) {
        validate(value);
        return getAnswer(toQueueString(value));
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

    private static void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new EmptyValueException();
        }
        if (!value.matches(VALIDATION_REGULAR)) {
            throw new InvalidValueException();
        }
    }
}
