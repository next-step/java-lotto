package study.step1.validator;

public class InputValidator {
    public static boolean valid(String input) {
        if(isEmpty(input) || isBlank(input)) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(String input) {
        return input == null;
    }

    public static boolean isBlank(String input) {
        return input.trim().isEmpty();
    }
}
