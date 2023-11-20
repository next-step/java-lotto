package lotto;

import java.util.Objects;

public class LottoNumber {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(String lottoNumber) {
        this(Integer.parseInt(lottoNumber.trim()));
    }

    public LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public void validate(int lottoNumber) {
        checkLottoNumberIsValid(lottoNumber);
    }

    private void checkLottoNumberIsValid(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(
                String.format("로또 번호는 %d ~ %d 사이만 가능합니다", MAX_NUMBER, MAX_NUMBER)
            );
        }
    }

    public int lottoNumber() {
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

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}
