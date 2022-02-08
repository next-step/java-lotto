package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validate(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지입니다");
        }
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

    public int getLottoNumber() {
        return lottoNumber;
    }
}
