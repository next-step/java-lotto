package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private final int number;
    private final boolean special;

    public LottoNumber(int number) {
        this(number, false);
    }

    public LottoNumber(int number, boolean special) {
        validate(number);

        this.number = number;
        this.special = special;
    }

    private void validate(int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException("로또번호의 범위는 1이상 45이상입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number && special == that.special;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, special);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return this.number - other.number;
    }
}
