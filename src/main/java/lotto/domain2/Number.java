package lotto.domain2;

import java.util.Objects;

public class Number {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private final int no;

    public Number(final int no) {
        if (MIN > no || no > MAX) {
            throw new IllegalArgumentException(String.format("로또번호는 %s 이상, %s 이하여야 합니다.", MIN, MAX));
        }

        this.no = no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return no == number.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }
}
