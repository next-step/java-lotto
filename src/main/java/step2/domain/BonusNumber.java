package step2.domain;

import step2.utils.Validation;

public class BonusNumber {

    private final int number;

    public BonusNumber(int bonusNumber) {
        Validation.validate(bonusNumber);
        this.number = bonusNumber;
    }

    public boolean isContained(Lotto lotto) {
        return lotto.contains(this.number);
    }
}
