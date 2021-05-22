package lotto.domain;

import java.util.Objects;

public class CustomNumber implements Number{
    private final int number;

    public CustomNumber(int number) {
        verifyNumbers(number);
        this.number = number;
    }

    @Override
    public int number() {
        return number;
    }

    @Override
    public int compareTo(Number o) {
        return number - o.number();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!Number.class.isAssignableFrom(o.getClass())) return false;
        Number that = (Number) o;
        return number == that.number();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
