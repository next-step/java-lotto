package calculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {

    private static final String REGEX_NOT_SYMBOL = "[^\\D]";
    private static final String REGEX_NOT_DIGIT = "[^\\d+]";
    private static final int MINIMUM_STARING_ARRAY_LENGTH = 3;

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public int calculate(String string) {

        do {
            checkString(string);

            String[] strings = string.split(" ");
            int length = strings.length;

            if (length == 1) {
                return Integer.parseInt(strings[0]);
            }

            if (length == 2) {
                throw new IllegalArgumentException("계산식은 2개의 숫자와 1개의 사칙연산 기호로 이루어집니다.");
            }

            for (int i = 0; i < MINIMUM_STARING_ARRAY_LENGTH; i++) {
                checkStringArray(regex(i), strings[i]);
            }

            string = string.replace(strings[0] + " " + strings[1] + " " + strings[2], String.valueOf(result(strings)));
        } while (true);

    }

    private int result(String[] strings) {
        String symbol = strings[1];
        int param1 = Integer.parseInt(strings[0]);
        int param2 = Integer.parseInt(strings[2]);

        if (symbol.equals(PLUS)) {
            return add(param1, param2);
        }
        if (symbol.equals(MINUS)) {
            return subtract(param1, param2);
        }
        if (symbol.equals(MULTIPLY)) {
            return multiply(param1, param2);
        }
        if (symbol.equals(DIVIDE)) {
            return divide(param1, param2);
        }
        throw new IllegalArgumentException(String.format("허용된 사칙연산 기호가 아닙니다.([%s])",symbol));
    }

    private void checkStringArray(String regex, String string) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            throw new IllegalArgumentException(String.format("계산할 문자열에 잘못된 정보가 존재합니다.([%s])",string));
        }
    }

    private int add(int i, int j) {
        return i + j;
    }

    private int subtract(int i, int j) {
        return i - j;
    }

    private int multiply(int i, int j) {
        return i * j;
    }

    private int divide(int i, int j) {
        if (j == 0) {
            throw new IllegalArgumentException("나누는 수는 0이 될 수 없습니다.");
        }
        return i / j;
    }

    private void checkString(Object s) {
        if (s == null || s.toString().isEmpty()) {
            throw new IllegalStateException("입력 값은 필수입니다.");
        }
    }

    private String regex(int i) {
        if (i % 2 == 0) {
            return REGEX_NOT_DIGIT;
        }
        return REGEX_NOT_SYMBOL;
    }
}
