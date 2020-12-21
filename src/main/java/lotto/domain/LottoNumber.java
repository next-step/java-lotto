package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        validNumber(number);
        this.number = number;
    }

    private void validNumber(int number) {
        if(number < MIN_NUMBER || number > MAX_NUMBER)
            throw new IllegalArgumentException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }

    @Override
    public int compareTo(LottoNumber compareNumber) {
        return Integer.compare(this.number, compareNumber.number);
    }

    public int getNumber() {
        return number;
    }
}
