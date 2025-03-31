package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
        this.lotto = lotto;
    }

    private void validateBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자가 기존 로또 번호와 겹칩니다.");
        }
    }

    public boolean contains(LottoNumber number) {
        return lotto.contains(number);
    }

    public boolean matchBonusNumber(List<LottoNumber> numbers) {
        return numbers.contains(bonusNumber);
    }
}
