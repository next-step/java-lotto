package lotto.model;

import java.util.Set;

public class WinningLotto  {
    private static final int LOTTO_NUMBER_START_RANGE = 1;
    private static final int LOTTO_NUMBER_END_RANGE = 45;

    private Lotto lotto;
    private Integer bonusNumber;

    public WinningLotto(Set<Integer> numbers, Integer bonusNumber) {
        this.lotto = new Lotto(numbers);

        validation(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(Lotto lotto) {
        return lotto.matchCount(this.lotto);
    }

    public boolean isBonusMatch(Lotto lotto) {
        return lotto.isBonusMatch(bonusNumber);
    }

    private void validation(Integer bonusNumber) {
        validationNumberRange(bonusNumber);
        validationNumberDuplicate(bonusNumber);
    }

    private void validationNumberDuplicate(Integer bonusNumber) {
        if(this.lotto.isBonusMatch(bonusNumber)) {
            throw new IllegalArgumentException("숫자는 중복하여 입력할 수 없습니다.");
        }
    }

    private void validationNumberRange(Integer number) {
        if(number < LOTTO_NUMBER_START_RANGE || number >LOTTO_NUMBER_END_RANGE) {
            throw new IllegalArgumentException("숫자는 1부터 45사이의 값을 입력하세요.");
        }
    }
}
