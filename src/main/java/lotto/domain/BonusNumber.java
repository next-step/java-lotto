package lotto.domain;

import java.util.Arrays;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        if (number < 1 || number > 45) throw new InvalidBonusNumberException(number);
        this.number = number;
    }

    public NumberMatcher bonusNumberMatcher() {
        return new ListNumberMatcher(Arrays.asList(number));
    }
}
