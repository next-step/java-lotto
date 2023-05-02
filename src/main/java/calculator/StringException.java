package calculator;

import java.util.regex.Pattern;

public class StringException {
    public static void checkEmptyString(String formula) {
        if (formula == null || formula.isBlank()) {
            throw new IllegalArgumentException("연산식을 입력해 주시기 바랍니다.");
        }
    }

    public static void checkNumber(String Number) {
        if (!Pattern.matches("^[0-9]*$", Number)) {
            throw new IllegalArgumentException("숫자자리에 다른 문자가 입력되었습니다.");
        }
    }

    public static void checkOperator(String item) {
        if (!(item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/"))) {
            throw new IllegalArgumentException("연산자 자리에 다른 문자가 입력되었습니다.");
        }
    }
}
