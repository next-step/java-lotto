package lotto.domain.result;

import lotto.domain.LottoNumberSetting;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        if (isValidNumber(number)) {
            throw new IllegalArgumentException("보너스번호는 1이상 45이하여야합니다");
        }
        this.number = number;
    }

    private boolean isValidNumber(int number) {
        return number < LottoNumberSetting.BEGIN_BOUND.getValue() || number > LottoNumberSetting.END_BOUND.getValue();
    }

    public int getNumber() {
        return this.number;
    }

    public boolean isSameNumber(final int number) {
        return this.number == number;
    }
}
