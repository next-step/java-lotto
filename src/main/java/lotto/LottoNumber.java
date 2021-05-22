package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 45;

    private int number;

    public LottoNumber(int number) throws IllegalArgumentException {
        checkValidValue(number);
        this.number = number;
    }

    private void checkValidValue(int number) throws IllegalArgumentException {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
