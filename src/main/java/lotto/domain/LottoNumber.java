package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOTTO_MIN_VALUE = 1;
    private static final int LOTTO_MAX_VALUE = 46;

    private final int number;

    public LottoNumber(int number) {
        this.number = validateNumber(number);
    }

    /**
     * 주어진 번호가 로또 번호의 조건에 맞는지 확인하고 반환합니다.
     * @param number
     * @return
     */
    public int validateNumber(int number) {
        if(this.isLottoNumber(number)) {
            return number;
        }
        throw new IllegalArgumentException("로또 숫자는 1 ~ 46 사이의 숫자만 가능합니다.");
    }

    /**
     * 주어진 번호가 로또 번호인지 확인합니다.
     * @param number
     * @return
     */
    private boolean isLottoNumber(int number) {
        return number >= LOTTO_MIN_VALUE && number <= LOTTO_MAX_VALUE;
    }

    public int getLottoNumber() {
        return this.number;
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
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.number - lottoNumber.number;
    }
}
