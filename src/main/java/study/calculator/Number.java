package study.calculator;

import study.calculator.exception.CalculatorException;

import java.util.Objects;

public class Number {

    public static final String NEGATIVE_NUMBER_EXCEPTION = "음수는 받을 수 없습니다.";
    public static final int ZERO = 0;

    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public static Number of(String number) {
        int parseInt = Integer.parseInt(number);
        if(parseInt < 0) {
            throw new CalculatorException(NEGATIVE_NUMBER_EXCEPTION);
        }
        return new Number(parseInt);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Number number1 = (Number) o;
        return getNumber() == number1.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
