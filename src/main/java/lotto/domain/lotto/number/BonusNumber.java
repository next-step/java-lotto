package lotto.domain.lotto.number;

import lotto.util.BonusNumberValidator;
import lotto.util.Validator;

public class BonusNumber extends Number {

    public BonusNumber(String input, Numbers numbers) {
        this(Validator.parseToInt(input), numbers);
    }

    public BonusNumber(Integer value, Numbers numbers) {
        super(BonusNumberValidator.validateDuplicateBonus(value, numbers.getNumbers()));
    }
}
