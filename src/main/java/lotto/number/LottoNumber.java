package lotto.number;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(int number) {
        isValid(number);
        this.number = number;
    }

    public int value() {
        return this.number;
    }

    private void isValid(int lottoNumber) {
        if (LottoNumberLimit.MAX.isUnder(lottoNumber) || LottoNumberLimit.MIN.isAbove(lottoNumber)) {
            throw new IllegalArgumentException("로또 숫자는 1 이상, 45 이하의 정수입니다.");
        }
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


    @Override
    public int compareTo(LottoNumber o) {
        return value() - o.value();
    }
}
