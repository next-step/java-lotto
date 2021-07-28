package stringcalculator;

import java.util.Objects;

public class NaturalNumber {

    public static final String NEGATIVE_NUMBER = "음수를 입력했습니다.";
    public static final String NOT_A_NUMBER = "숫자 이외의 값을 입력했습니다.";

    private int number;

    private NaturalNumber(int number) {
        if (number < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER);
        }
        this.number = number;
    }

    public static NaturalNumber valueOf(int i) {
        return new NaturalNumber(i);
    }

    public static NaturalNumber valueOf(String s) {
        try {
            int number = Integer.parseInt(s);
            return new NaturalNumber(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException(NOT_A_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NaturalNumber that = (NaturalNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
