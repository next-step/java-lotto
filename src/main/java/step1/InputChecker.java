package step1;

public class InputChecker {
    public static boolean isNullOrEmpty(String input) {
        if(isNull(input) || isEmpty(input)) {
            return true;
        }
        return false;
    }

    private static boolean isNull(String input) {
        if(input == null) {
            return true;
        }
        return false;
    }

    private static boolean isEmpty(String input) {
        if(input.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isOnlyNumber(String input) {
        if(input.matches("^[0-9]*$")) {
            return true;
        }
        return false;
    }
}
