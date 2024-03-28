package step1.controller;


import step1.config.message.ErrorMessage;
import step1.domain.Numbers;
import step1.domain.Operator;
import step1.domain.Operators;

public class StringCalculator {

    public static int calculate(String string) {
        validateNull(string);

        Numbers numbers = new Numbers(string);
        Operators operators = new Operators(string);

        int result = numbers.poll();

        for (Operator operator : operators.getOperators()) {
            result = operator.calculate(result, numbers.poll());
        }
        return result;
    }

    private static void validateNull(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY_VALIDATION.message());
        }
    }
}
