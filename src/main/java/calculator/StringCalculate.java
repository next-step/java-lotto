package calculator;

public class StringCalculate {
    public int add(String input) {
        if (isBlankString(input)) {
            return 0;
        }
        return 0;
    }

    private boolean isBlankString(String str) {
        return str == null || str.length() == 0;
    }
}
