package lotto.domain.lotto.number;

import lotto.util.BonusNumberValidator;
import lotto.util.Validator;

public class BonusNumber {

    private final Number number;

    public BonusNumber(String input, Numbers numbers) {
        this(Validator.parseToInt(input), numbers);
    }

    public BonusNumber(Integer value, Numbers numbers) {
        this.number = new Number(BonusNumberValidator.validateDuplicateBonus(value, numbers.getNumbersValue()));
    }

    public Number getNumber() {
        return number;
    }
}
