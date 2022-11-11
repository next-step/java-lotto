package lotto.domain;

import lotto.exception.DuplicateLottoNumberException;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
        if (winningLotto.containLottoNumber(bonusBall)) {
            throw new DuplicateLottoNumberException();
        }
    }

    public long matchCount(List<LottoNumber> lottoNumbers) {
        return winningLotto.winningCount(lottoNumbers);
    }

    public boolean matchBonus(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(bonusBall);
    }
}
