package lotto.domain;

import java.util.Objects;

public class IntNumber {

    private final int number;

    public IntNumber(String numberText) {
        this(toInt(numberText));
    }

    public IntNumber(int number) {
        this.number = number;
    }

    private static int toInt(String numberText) {
        try {
            return Integer.parseInt(numberText);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(String.format("문자를 숫자로 변경할 수 없습니다. 입력된 문자 : %s", numberText));
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntNumber intNumber = (IntNumber) o;
        return number == intNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
