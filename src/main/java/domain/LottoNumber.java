package domain;

import java.util.Objects;

public class LottoNumber {
    public final static int MAX_NUMBER = 45;
    public final static int MIN_NUMBER = 1;
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNumberRange(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private void validateNumberRange(Integer lottoNumber) {
        if (lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d 이상 %d 이하여야 합니다.", MIN_NUMBER, MAX_NUMBER));
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
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
