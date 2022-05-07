package lotto.util;

public class StringNumberUtils {
    private StringNumberUtils() {
    }

    public static int parse(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(String.format("%s는 숫자가 아닙니다.", stringNumber));
        }
    }
}
