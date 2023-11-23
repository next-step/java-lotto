package step2.domain;

import java.util.Objects;

public class LottoNumber {
    private final int number;
    public final static int LOTTO_NUM_START=1;
    public final static int LOTTO_NUM_END=45;

    public LottoNumber(int number) {
        checkNumber(number);
        this.number = number;
    }

    public int number() {
        return number;
    }

    private void checkNumber(int number) {
        if (number < LOTTO_NUM_START || number > LOTTO_NUM_END) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return number == lottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
