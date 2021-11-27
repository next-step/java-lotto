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

    public int getNumber() {
        return number;
    }

    public String getNumberString() {
        return String.valueOf(this.number);
    }

    private void validateLottoNumber(final int number) {
        if (number <= BASE || number > BOUND) {
            throw new RuntimeException();
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        if (this.getNumber() > o.getNumber()) {
            return 1;
        }
        if (this.getNumber() == o.getNumber()) {
            return 0;
        }
        return -1;
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
