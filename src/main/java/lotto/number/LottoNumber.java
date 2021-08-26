package lotto.number;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        isValid(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getValue() {
        return this.lottoNumber;
    }

    private void isValid(int lottoNumber) {
        if (Limit.MAX.isUnder(lottoNumber) || Limit.MIN.isAbove(lottoNumber)) {
            throw new IllegalArgumentException("로또 숫자는 1 이상, 45 이하의 정수입니다.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }


    @Override
    public int compareTo(LottoNumber o) {
        return o.getValue() - getValue();
    }
}
