package lottogame.model;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private int number;

    final static int LOTTO_MAX_NUM = 45;
    final static int LOTTO_MIN_NUM = 1;

    public LottoNumber(int lottoNumber) {
        validateLottoRange(lottoNumber);
        this.number = lottoNumber;
    }

    private static void validateLottoRange(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN_NUM || lottoNumber > LOTTO_MAX_NUM) {
            throw new IllegalArgumentException("로또 번호는 1~45 까지 가능합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
