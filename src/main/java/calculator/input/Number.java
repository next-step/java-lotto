package calculator.input;


import java.util.regex.Pattern;

public class Number {
    private static final String REGEX_NUMBER = "-?\\d+(\\.\\d+)?";
    private static final Pattern PATTERN_NUMBER = Pattern.compile(REGEX_NUMBER);

    private int number;

    public Number(final int number) {
        this.number = number;
    }

    public Number(final String value) {
        this.number = parseInt(value);
    }

    public int getNumber() {
        return number;
    }

    public int parseInt(String str) {
        checkNumber(str);
        return Integer.parseInt(str);
    }

    private void checkNumber(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("숫자에 빈 값이 존재합니다.");
        }

        if (!PATTERN_NUMBER.matcher(str).matches()) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
