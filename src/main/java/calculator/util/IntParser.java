package calculator.util;

public class IntParser {

    private IntParser() {
    }

    public static int parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자열은 사용할 수 없습니다.");
        }
    }
}
