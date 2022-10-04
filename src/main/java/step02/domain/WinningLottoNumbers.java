package step02.domain;

import java.util.HashSet;
import java.util.List;

public class WinningLottoNumbers {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(Lotto lotto, LottoNumber bonusNumber) {
        validateIsDuplicated(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lotto.getValue();
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validateIsDuplicated(Lotto lotto, LottoNumber bonusNumber) {
        if (new HashSet<>(lotto.getValue()).contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 로또 번호와 중복될 수 없습니다.");
        }
    }
}
