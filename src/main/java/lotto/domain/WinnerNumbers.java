package lotto.domain;

import java.util.Set;

public class WinnerNumbers {
    private final Set<LottoNumber> winnerNumbers;
    private final BonusNumber bonusNumber;

    public WinnerNumbers(Set<LottoNumber> winnerNumbers, BonusNumber bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return winnerNumbers;
    }

    public boolean isMatchBonus(LottoNumbers lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
