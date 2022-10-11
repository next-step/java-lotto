package validator;

import java.util.InputMismatchException;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class InputValidator {

    private final static Pattern PATTERN_NUMBER = Pattern.compile("^-?\\d+$");
    private final static Pattern PATTERN_OPERATOR = Pattern.compile("[+\\-*/]");
    private final static String SEPARATOR = " ";

    private InputValidator() {
    }

    public static boolean containSeparator(String expression) {
        if (expression.trim().contains(SEPARATOR)) {
            return true;
        }
        throw new InputMismatchException("계산식은 '" + SEPARATOR + "' 값으로 구분해야 합니다.");
    }

    public static boolean isValidOperand(String expression) {
        if (IntStream.range(0, expression.split(SEPARATOR).length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> expression.split(SEPARATOR)[i])
                .allMatch(InputValidator::isNumeric)) {
            return true;
        }
        throw new InputMismatchException("입력하신 피연산자의 값이 올바르지 않습니다.");
    }

    public static boolean isValidOperator(String expression) {
        if (IntStream.range(0, expression.split(SEPARATOR).length)
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> expression.split(SEPARATOR)[i])
                .allMatch(InputValidator::isOperator)) {
            return true;
        }
        throw new InputMismatchException("입력하신 연산자의 값이 올바르지 않습니다.");
    }

    public static boolean isNumeric(String text) {
        if (isNullOrSpace(text)) {
            return false;
        }
        return PATTERN_NUMBER.matcher(text).matches();
    }

    public static boolean isOperator(String text) {
        if (isNullOrSpace(text)) {
            return false;
        }
        return PATTERN_OPERATOR.matcher(text).matches();
    }

    public static boolean isContains(String text, CharSequence separator) {
        if (isNullOrSpace(text)) {
            return false;
        }
        return text.contains(separator);
    }

    private static boolean isNullOrSpace(String text) {
        return text == null || text.equals("");
    }
}
