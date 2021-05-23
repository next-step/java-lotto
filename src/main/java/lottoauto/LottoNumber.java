package lottoauto;

import java.util.Objects;

public class LottoNumber {
    protected static final int LOTTO_NUMBER_START = 1;
    protected static final int LOTTO_NUMBER_END = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateRange(int lottoNumber) {
        if (lottoNumber < LOTTO_NUMBER_START || LOTTO_NUMBER_END < lottoNumber) {
            throw new IllegalArgumentException("1과 45 사이의 정수여야 합니다.");
        }
    }

    public int lottoNumber() {
        return lottoNumber;
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
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}
