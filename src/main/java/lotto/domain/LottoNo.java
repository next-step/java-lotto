package lotto.domain;

import java.util.Objects;

import lotto.exception.LottoNumberException;

public class LottoNo implements Comparable<LottoNo> {
    private final int number;

    public LottoNo(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < Lotto.LOTTO_NUMBER_START || number > Lotto.LOTTO_NUMBER_END) {
            throw new LottoNumberException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public int compareTo(LottoNo lottoNo) {
        return Integer.compare(this.number, lottoNo.number);
    }
}
