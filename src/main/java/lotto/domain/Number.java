package lotto.domain;

import java.util.Objects;

public class Number implements Comparable<Number> {
    public static final int START_NUM = 1;
    public static final int END_NUM = 46;
    private final int number;

    public Number(int number) {
        if (number < START_NUM || number > END_NUM - 1)
            throw new IllegalArgumentException("Number must be between 1 and 45");

        this.number = number;
    }

    public int getNumber() {
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

    @Override
    public int compareTo(Number compared) {
        return Integer.compare(number, compared.number);
    }
}
