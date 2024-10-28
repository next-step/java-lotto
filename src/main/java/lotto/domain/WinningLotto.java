package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        if (outOfRange(bonusNumber) || this.containNumber(bonusNumber)) {
            throw new IllegalArgumentException("올바르지 않은 입력 입니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.containNumber(bonusNumber);
    }
}
