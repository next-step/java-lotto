package study.calculator;

import study.calculator.exception.CalculatorException;

import java.util.Objects;

import static study.calculator.Validator.*;

public class Number {

    private final int number;

    protected Number(int number) {
        this.number = number;
    }

    public static Number of(String number) {
        if(isNotNumericOrIsNegativeNumber(number)) {
            throw new CalculatorException("계산할 수 없는 문자 입니다.");
        }
        return new Number(Integer.parseInt(number));
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        final Number number1 = (Number) o;
        return getNumber() == number1.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
