package calculator.validation;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final String OPERATION_REGULAR = "[+\\-*/]";
    private static final Pattern OPERATION_PATTERN = Pattern.compile(OPERATION_REGULAR);

    private Validation(){
        throw new IllegalStateException("Utility Class");
    }


    public static int checkNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException err) {
            throw new NumberFormatException("숫자만 사칙연산이 가능합니다");
        }
    }

    public static String checkFourBasicOperation(String sign) {
        Matcher m = OPERATION_PATTERN.matcher(sign);

        if (m.find()) {
            return sign;
        }
        throw new InputMismatchException("사칙연산 기호만 사용하여 주세요");
    }

}
