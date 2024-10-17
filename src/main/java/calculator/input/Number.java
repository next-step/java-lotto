package calculator.input;


public class Number {
    public static final String REGEX_NUMBER = "-?\\d+(\\.\\d+)?";

    private int number;

    public Number(final int number){
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

        if (!str.matches(REGEX_NUMBER)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
