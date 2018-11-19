package lotto.model;

import java.util.Set;

public class WinningLotto  {
    private Lotto lotto;
    private LottoNo bonusNumber;

    private WinningLotto(Set<Integer> numbers, LottoNo bonusNumber) {
        this.lotto = Lotto.from(numbers);

        validation(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(Set<Integer> numbers, LottoNo bonusNumber) {
       return new WinningLotto(numbers, bonusNumber);
    }

    public int matchCount(Lotto lotto) {
        return lotto.matchCount(this.lotto);
    }

    public boolean isBonusMatch(Lotto lotto) {
        return lotto.isBonusMatch(bonusNumber);
    }

    private void validation(LottoNo bonusNumber) {
        validationNumberDuplicate(bonusNumber);
    }

    private void validationNumberDuplicate(LottoNo bonusNumber) {
        if(this.lotto.isBonusMatch(bonusNumber)) {
            throw new IllegalArgumentException("숫자는 중복하여 입력할 수 없습니다.");
        }
    }
}
