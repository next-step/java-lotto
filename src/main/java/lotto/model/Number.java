package lotto.model;

import java.util.Objects;

public class Number implements Comparable<Number> {
    private int number;

    public Number(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("input value in 1~45");
        }
        this.number = number;
    }

    public Number(String number) {
        this(Integer.parseInt(number));
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

    public int value() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(Number o) {
        if (this.number < o.number){
            return -1;
        } else if (this.number > o.number){
            return 1;
        }
        return 0;
    }
}
