package calculator;

import java.util.Objects;

public class Number {
    private static final String numberRegExp = "^[0-9]+$";
    private int number;

    public Number(String stringNum) {
        validCheck(stringNum);
        this.number = Integer.parseInt(stringNum);
    }

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validCheck(String input) {
        if (!input.matches(numberRegExp)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

}
