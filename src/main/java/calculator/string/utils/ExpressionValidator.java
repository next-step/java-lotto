package calculator.string.utils;

public class ExpressionValidator {
    public static void checkNumberValidation(String number) throws IllegalArgumentException {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 데이터입니다.");
        }
    }
}
