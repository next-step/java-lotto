package lotto.domain.lotto.number;

import lotto.util.BonusNumberValidator;

public class BonusNumber extends Number {

    private final Integer value;

    public BonusNumber(String input, Numbers numbers) {
        this(BonusNumberValidator.parseToInt(input), numbers);
    }

    public BonusNumber(Integer value, Numbers numbers) {
        super(value);
        this.value = BonusNumberValidator.validateDuplicateBonus(value, numbers.getNumbers());
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
