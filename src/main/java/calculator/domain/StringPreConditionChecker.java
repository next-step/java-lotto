package calculator.domain;

public class StringPreConditionChecker {

    public static boolean isRightString(String text) {

        if (text == null) {
            return false;
        }

        if (text.isEmpty()) {
            return false;
        }

        if (text.contains("-")) {
            throw new RuntimeException();
        }

        return true;
    }
}
