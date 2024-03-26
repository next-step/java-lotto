package calculator;

import java.util.Objects;

public class StringCalculator {
    public static int sum(int numberA,
                          int numberB) {
        return numberA + numberB;
    }

    public static int difference(int numberA,
                                 int numberB) {
        return numberA - numberB;
    }

    public static int product(int numberA,
                              int numberB) {
        return numberA * numberB;
    }

    public static int quotient(int numberA,
                               int numberB) {
        return numberA / numberB;
    }

    public static String[] splitWithSpace(String input) {
        return input.split(" ");
    }

    public static void validateInput(String input) {
        if(Objects.isNull(input))
            throw new IllegalArgumentException("입력값은 null이면 안됩니다.");
        if(input.isBlank())
            throw new IllegalArgumentException("입력값은 빈공간이면 안됩니다.");
    }

    public static void validateExpression(String[] inputArray) {
        if(inputArray.length % 2 == 0)
            throw new IllegalArgumentException("올바른 수식이 아닙니다.");
    }
}
