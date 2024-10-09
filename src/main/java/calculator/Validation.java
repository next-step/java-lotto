package calculator;

public class Validation {
    public static void checkNullOrBlank(String input) {
        if(isNullOrBlank(input)) {
            throw new IllegalArgumentException();
        }
    }
    private static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }
}
