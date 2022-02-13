package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private int lottoNumber;

    public LottoNumber(String input) {
        this.lottoNumber = this.validatorValue(Integer.parseInt(input));
    }

    public LottoNumber(int input) {
        this.lottoNumber = this.validatorValue(input);
    }

    public int validatorValue(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("1 이상 45 이하의 수를 입력해주세요");
        }
        return value;
    }

    public int getLottoNumber() {
        return this.lottoNumber;
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
}
