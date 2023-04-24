package stringcalculator.util;

public class StringParser {

    private StringParser() {
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 값이 자연수가 아닙니다.");
        }
    }
}
