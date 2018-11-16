package lotto.model;

import java.util.Set;

public class WinningLotto extends Lotto {
    private Integer bonusNumber;

    public WinningLotto(Set<Integer> numbers, Integer bonusNumber) {
        super(numbers);

        validation(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean isBonusMatch(Lotto lotto) {
        return lotto.numbers.contains(bonusNumber);
    }

    protected void validation(Integer bonusNumber) {
        validationNumberRange(bonusNumber);
        validationNumberDuplicate(bonusNumber);
    }

    protected void validationNumberDuplicate(Integer bonusNumber) {
        if(this.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("숫자는 중복하여 입력할 수 없습니다.");
        }
    }
}
