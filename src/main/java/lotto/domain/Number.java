package lotto.domain;

import java.util.Objects;

public class Number {
    private final int value;

    private Number(String stringNumber) {
        try {
            this.value = Integer.parseInt(stringNumber);
        } catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

    private Number(int value) {
        this.value = value;
    }

    public static Number parse(String stringNumber) {
        return new Number(stringNumber);
    }

    public static Number of(int number) {
        return new Number(number);
    }

    public static boolean isNumber(String stringNumber) {
        try {
            parse(stringNumber);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Number)) {
            return false;
        }
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Number add(Number number) {
        return new Number(this.value + number.value);
    }

    public Number minus(Number number) {
        return new Number(this.value - number.value);
    }

    public Number multiply(Number number) {
        return new Number(this.value * number.value);
    }

    public Number divide(Number number) {
        return new Number(this.value / number.value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Number{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
