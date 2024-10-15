package lotto.domain;

import java.util.Objects;

public class Lottonumber {

    private static final int MININUM = 1;
    private static final int MAXIMUM = 45;

    private final int number;

    public Lottonumber(int number) {
        if (number < MININUM || number > MAXIMUM) {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 사용할 수 있습니다.");
        }

        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lottonumber that = (Lottonumber) o;

        return this.number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}

