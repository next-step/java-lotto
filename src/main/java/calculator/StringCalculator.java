package calculator;

public class StringCalculator {

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null 또는 공백이 들어옴");
        }
        return 0;
    }
}
