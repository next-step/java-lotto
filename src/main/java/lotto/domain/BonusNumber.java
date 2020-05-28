package lotto.domain;

import static lotto.domain.LottoGameProperty.LOTTO_NUMBER_BEGIN_BOUND;
import static lotto.domain.LottoGameProperty.LOTTO_NUMBER_END_BOUND;

public class BonusNumber {
    private final int value;

    public BonusNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < LOTTO_NUMBER_BEGIN_BOUND || value > LOTTO_NUMBER_END_BOUND) {
            throw new IllegalArgumentException("로또 숫자는 1과 45사이여아 합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    public boolean isSameNumber(LottoNumber lottoNumber) {
        return this.value == lottoNumber.getValue();
    }
}
