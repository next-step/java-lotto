package step2.model;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(int lottoNumber) {
        validateLottoNumber(lottoNumber);

        return new LottoNumber(lottoNumber);
    }

    private static void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_VALUE || lottoNumber > MAX_VALUE) {
            throw new IllegalArgumentException("로또 번호가 올바르지 않습니다.");
        }
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
