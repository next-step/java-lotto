package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int BASE = 0;
    private static final int BOUND = 45;

    private final int number;

    public LottoNumber(final String text) {
        this(Integer.parseInt(text));
    }

    public LottoNumber(final int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    public String getNumber() {
        return String.valueOf(this.number);
    }

    private void validateLottoNumber(final int number) {
        if (number <= BASE || number > BOUND) {
            throw new RuntimeException();
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
