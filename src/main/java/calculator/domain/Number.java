package calculator.domain;

import calculator.exception.NumberConstraintViolationException;

import java.util.Objects;

public class Number {
    private final int number;

    /**
     * Number 생성자
     *
     * @param number 양의 정수로 변환 가능한 숫자 문자열
     * @throws NumberConstraintViolationException 숫자 이외의 값 또는 음수를 전달하는 경우
     */
    public Number(String number) {
        try {
            this.number = Integer.parseUnsignedInt(number);
        } catch (NumberFormatException exception) {
            throw new NumberConstraintViolationException("숫자 이외의 값 또는 음수 문자열로 Number를 생성할 수 없습니다.");
        }
    }

    private Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public Number add(Number number) {
        return new Number(this.number + number.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
