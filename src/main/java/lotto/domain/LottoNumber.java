package lotto.domain;

import lotto.common.LottoValidator;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        LottoValidator.validateLottoNumberRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber)obj;
        return number == that.number;
    }
}
