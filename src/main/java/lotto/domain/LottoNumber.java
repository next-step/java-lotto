package lotto.domain;

import lotto.exception.LottoApplicationException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    private final int number;

    public LottoNumber(int number) {
        if (number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER) {
            throw new LottoApplicationException("로또 숫자는 1이상 45 이하로만 생성 가능합니다.");
        }
        this.number = number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        if (this.number > o.number) {
            return 1;
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
