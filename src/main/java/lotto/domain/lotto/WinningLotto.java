package lotto.domain.lotto;

import lotto.domain.lotto.number.BonusNumber;
import lotto.domain.lotto.number.Number;
import lotto.domain.lotto.number.Numbers;

public class WinningLotto extends Lotto {

    private final BonusNumber bonusNumber;

    public WinningLotto(Numbers numbers, BonusNumber bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Number getBonusNumber() {
        return bonusNumber.getNumber();
    }
}
