package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorValidator {
    private static final String NUMBER_REGULAR = "^[0-9]+$";
    private static final int MINUS_CONDITION = 0;

    public static void validate(String text) {
        validateNumbers(text);
        validateMinus(text);
    }

    private static void validateMinus(String text) {
        if(Integer.parseInt(text) < MINUS_CONDITION) {
            throw new RuntimeException("음수는 입력 받을 수 없습니다.");
        }
    }

    private static void validateNumbers(String text) {
        Matcher m = Pattern.compile(NUMBER_REGULAR).matcher(text);
        if(!m.find()) {
            throw new RuntimeException("숫자가 아닌 값은 입력받을 수 없습니다.");
        }
    }

}
