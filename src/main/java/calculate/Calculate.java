package calculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {

    private static final String STRING_ARRAY_SYMBOL = "[^\\D]";
    private static final String STRING_ARRAY_DIGIT = "[^\\d+]";
    private static final int MINIMUM_STARING_ARRAY_LENGTH = 3;

    public int add(int i, int j) {
        return i + j;
    }

    public int subtract(int i, int j) {
        return i - j;
    }

    public int multiply(int i, int j) {
        return i * j;
    }

    public int divide(int i, int j) {
        if (j == 0) {
            throw new IllegalArgumentException("두번째 인자는 0 일 수 없습니다.");
        }
        return i / j;
    }

    public void checkString(Object s) {
        if (s == null || s.toString().isEmpty()) {
            throw new IllegalStateException("입력 값은 필수입니다.");
        }
    }


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
            checkStringArray(stringType(i), strings[i]);
        }

        return calculate(s.replace(strings[0] + " " + strings[1] + " " + strings[2], String.valueOf(getResult(strings))));
    }

    private int getResult(String[] strings) {
        String symbol = strings[1];
        String param1 = strings[0];
        String param2 = strings[2];

        if (symbol.equals("+")) {
            return add(Integer.parseInt(param1), Integer.parseInt(param2));
        }
        if (symbol.equals("-")) {
            return subtract(Integer.parseInt(param1), Integer.parseInt(param2));
        }
        if (symbol.equals("*")) {
            return multiply(Integer.parseInt(param1), Integer.parseInt(param2));
        }

        return divide(Integer.parseInt(param1), Integer.parseInt(param2));
    }


    private void checkStringArray(String regex, String string) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            throw new IllegalArgumentException("형식에 맞지 않는 문자열 입니다.");
        }
    }

    private String stringType(int i) {
        if (i % 2 == 0) {
            return STRING_ARRAY_DIGIT;
        }
        return STRING_ARRAY_SYMBOL;
    }
}
