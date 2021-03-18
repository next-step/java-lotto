package step1.domain;

import step1.NegativeException;

import java.util.Objects;

public class Number {

    private int number;

    public Number(String number) {
        this.number = change(number);
    }

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private int change(String text) {
        int number = Integer.parseInt(text);
        if (number < 0) {
            throw new NegativeException();
        }

        return number;
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
