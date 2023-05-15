package step1.domain;

import java.util.Objects;

public class Number {
    private final long number;

    public Number(long number) {
        this.number = number;
    }

    public static Number of(String number) {
        checkNumber(number);
        return new Number(Long.parseLong(number));
    }

    public static void checkNumber(String number) {
        if(!number.matches("^-?\\d+(\\.\\d+)?$")) {
            throw new IllegalArgumentException("Wrong number!");
        }
    }

    public Number operate(Operator operator, Number target) {
        if(operator == null) {
            return this;
        }
        return new Number(operator.calculate(this.number, target.number));
    }

    public long getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
