package stringcalculator.util;

public class Parser {

    private Parser() {
    }

    public static int parseInteger(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
    }
}
