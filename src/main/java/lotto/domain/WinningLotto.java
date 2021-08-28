package lotto.domain;

import java.util.Set;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public boolean checkBonusNumber(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
