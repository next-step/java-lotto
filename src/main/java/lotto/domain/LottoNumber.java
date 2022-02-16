package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final int LOTTO_START_RANGE = 1;
    private static final int LOTTO_END_RANGE = 45;
    private static final String LOTTO_RANGE_ERROR = "1 이상 45 이하의 수를 입력해주세요";

    private final int lottoNumber;

    public LottoNumber(final String input) {
        this.lottoNumber = this.validatorValue(Integer.parseInt(input));
    }

    public LottoNumber(final int value) {
        this.lottoNumber = this.validatorValue(value);
    }

    public int validatorValue(final int value) {
        if (value < LOTTO_START_RANGE || value > LOTTO_END_RANGE) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR);
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
