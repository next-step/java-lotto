package step1.model;

import step1.exception.DivideByZeroException;
import step1.exception.ParseNumberException;

import java.util.Objects;

public class NumberCalculation {

    private int number;

    public NumberCalculation(int number) {
        this.number = number;
    }

    public NumberCalculation(String number) {
        try {
            this.number = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new ParseNumberException(String.format("[입력 오류] 입력된 문자가 숫자가 아닙니다. input: %s", number));
        }
    }

    public int getNumber() {
        return number;
    }

    public void sum(final int number) {
        this.number += number;
    }

    public void subtract(final int number) {
        this.number -= number;
    }

    public void multiply(final int number) {
        this.number *= number;
    }

    public void divided(final int number) {
        if (number == 0) {
            throw new DivideByZeroException("[연산 오류] 숫자를 0으로 나눌 수 없습니다.");
        }

        this.number /= number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberCalculation that = (NumberCalculation) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
