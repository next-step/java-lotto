package lotto.domain.lotto;

import lotto.domain.lotto.number.Number;
import lotto.domain.lotto.number.Numbers;

public class WinningLotto extends Lotto {

    private final Number bonusNumber;

    public WinningLotto(Numbers numbers, Number bonusNumber) {
        super(numbers);
        validateWinningLotto(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningLotto(Numbers numbers, Number bonusNumber) {
        if (numbers.has(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 값입니다. 다시 입력해주세요.");
        }
    }

    public Number getBonusNumber() {
        return bonusNumber;
    }
}
