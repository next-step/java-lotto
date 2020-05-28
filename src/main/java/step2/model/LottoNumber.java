package step2.model;

import java.util.Objects;

public class LottoNumber {

    private static final int LOTTO_NUMBER_MIN_VALUE = 1;
    private static final int LOTTO_NUMBER_MAX_VALUE = 45;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(int lottoNumber) {
        if (lottoNumber < LOTTO_NUMBER_MIN_VALUE
                || lottoNumber > LOTTO_NUMBER_MAX_VALUE) {
            throw new IllegalArgumentException("로또 번호가 올바르지 않습니다.");
        }

        return new LottoNumber(lottoNumber);
    }

    public int get() {
        return this.lottoNumber;
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
}
