package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorValidator {

    public static void validateMinus(String text) {
        if(text.contains("-")) {
            throw new RuntimeException("음수는 입력 받을 수 없습니다.");
        }
    }

    public static void validateNumbers(String text) {
        Matcher m = Pattern.compile("^[0-9]+$").matcher(text);
        if(!m.find()) {
            throw new RuntimeException("숫자가 아닌 값은 입력받을 수 없습니다.");
        }
    }

}
