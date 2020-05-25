package step1;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (!validateText(text)) {
            return 0;
        }

        return -1;
    }

    private static Boolean validateText(String text) {
        if (text == null) {
            return false;
        }
        if (text.isEmpty()) {
            return false;
        }

        return true;
    }
}
