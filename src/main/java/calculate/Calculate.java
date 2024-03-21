package calculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {

    private static final String REGEX_NOT_SYMBOL = "[^\\+|\\-|\\*|\\/]";
    private static final String REGEX_NOT_DIGIT = "[^\\d+]";
    private static final int MINIMUM_STARING_ARRAY_LENGTH = 3;

    public int calculate(String s) {

        checkString(s);

        String[] strings = s.split(" ");
        int length = strings.length;

        if (length == 1) {
            return Integer.parseInt(strings[0]);
        }

        if (length == 2) {
            throw new IllegalArgumentException("계산식이 정확하지 않습니다.");
        }

        for (int i = 0; i < MINIMUM_STARING_ARRAY_LENGTH; i++) {
            checkStringArray(regex(i), strings[i]);
        }

        return calculate(s.replace(strings[0] + " " + strings[1] + " " + strings[2], String.valueOf(getResult(strings))));
    }

    private int getResult(String[] strings) {
        String symbol = strings[1];
        int param1 = Integer.parseInt(strings[0]);
        int param2 = Integer.parseInt(strings[2]);

        if (symbol.equals("+")) {
            return add(param1, param2);
        }
        if (symbol.equals("-")) {
            return subtract(param1, param2);
        }
        if (symbol.equals("*")) {
            return multiply(param1, param2);
        }

        return divide(param1, param2);
    }

    private void checkStringArray(String regex, String string) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            throw new IllegalArgumentException("형식에 맞지 않는 문자열 입니다.");
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
            throw new IllegalArgumentException("두번째 인자는 0 일 수 없습니다.");
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
