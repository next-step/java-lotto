package step2.domain;

import java.util.List;
import step2.utils.Validation;

public class BonusNumber {

    private final int number;

    public BonusNumber(int bonusNumber) {
        Validation.validate(bonusNumber);
        this.number = bonusNumber;
    }

    public Integer get() {
        return this.number;
    }

    public boolean isContained(List<Integer> numbers) {
        return numbers.contains(this.number);
    }
}
