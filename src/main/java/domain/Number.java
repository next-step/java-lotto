package domain;

import java.util.Objects;

public class Number {
    private static final int MININUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 46;
    private Integer number;

    private Number(Integer number) {
        if (number < MININUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public static Number createInstance(Integer integerNumber) {
        return new Number(integerNumber);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number1 = (Number) o;
        return Objects.equals(number, number1.number);
    }
}
