package lotto.model;

import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LOTTO_MINIMUM_NUMBER) {
            throw new IllegalArgumentException("로또번호는 1보다 작을 수 없습니다.");
        }

        if (number > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("로또번호는 45보다 클 수 없습니다.");
        }
    }

    public boolean hasMatchNumbers(List<LottoNumber> numbers) {
        return numbers.contains(this);
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
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
