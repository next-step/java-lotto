package calculator;

public class StringCalculator {

    public static int calculate(String input) {
        StringCalculatorValidator.validateOrThrow(input);
        return 0;
    }
}
