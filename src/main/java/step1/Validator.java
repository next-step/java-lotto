package step1;

public class Validator {
    private Validator() {}

    private static final String CHECK_CUSTOM_REGEX = "^//.*\\n.*$";

    public static boolean checkCustomDelimiter(String input) {
        return input.matches(CHECK_CUSTOM_REGEX);
    }

    public static boolean checkSingle(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkZero(String input) {
        return checkNull(input) || checkEmpty(input);
    }

    private static boolean checkNull(String input) {
        return input == null;
    }

    private static boolean checkEmpty(String input) {
        return input.isEmpty();
    }
}
