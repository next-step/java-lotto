package lotto.domain.model;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNumber());
    }

    private void validateNumber(int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) throw new IllegalArgumentException("로또 번호의 범위를 넘어선 값으로 생성할 수 없습니다.");
    }
}
