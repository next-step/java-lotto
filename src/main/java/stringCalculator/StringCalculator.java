package stringCalculator;

import java.util.*;

public class StringCalculator {
    private final StringValidator stringValidator = new StringValidator();

    public int calculate(String input) {
        stringValidator.validate(input);

        Queue<String> tokens = new LinkedList<>(List.of(input.split(" ")));

        int result = Integer.parseInt(tokens.poll());
        while (!tokens.isEmpty()) {
            String operator = tokens.poll();
            int nextNumber = Integer.parseInt(tokens.poll());
            result = OperatorFactory.getCalculator(operator).calculate(result, nextNumber);
        }

        return result;
    }
}
