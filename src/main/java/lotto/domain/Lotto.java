package lotto.domain;

import java.util.Objects;

public class Lotto {
    private int number;

    public Lotto(int number) {
        this.validateLottoNumber(number);
        this.number = number;
    }

    private void validateLottoNumber(int number) {
        if (number < LottoNumbers.MIN_RANGE) {
            throw new IllegalArgumentException(String.format("lottoNumber should be greater than %d.", LottoNumbers.MIN_RANGE));
        }

        if (number >= LottoNumbers.MAX_RANGE) {
            throw new IllegalArgumentException(String.format("lottoNumber should be less than %d.", LottoNumbers.MIN_RANGE));
        }
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) o;
        return Objects.equals(lotto.getNumber(), this.number);
    }
}
