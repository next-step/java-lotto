package step4.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private int lottoNumber;
    private static final int MIN_LOTTO_RANGE = 1;
    private static final int MAX_LOTTO_RANGE = 45;

    private LottoNumber(int number) {
        validateLottoNumber(number);
        this.lottoNumber = number;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    private void validateLottoNumber(int number) {
        if (number < MIN_LOTTO_RANGE || number > MAX_LOTTO_RANGE) {
            throw new IllegalArgumentException("로또 번호의 범위는 1~45까지입니다.");
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;

        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }
}
