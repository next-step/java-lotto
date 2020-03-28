package step1;

public class InputChecker {
    public static boolean isNullOrEmpty(String input) {
        return isNull(input) || isEmpty(input);
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static boolean isEmpty(String input) {
        return input.trim().isEmpty();
    }
}
