package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private final int value;

    public LottoNumber(int number) {
        validateLottoNumber(number);
        this.value = number;
    }

    private static void validateLottoNumber(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("로또 번호는 1에서 45까지만 입력할 수 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.value, o.value);
    }
}
