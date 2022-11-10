package lotto.domain;


import lotto.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(LottoNumberStrategy numberStrategy) {
        lottoNumbers = new ArrayList<>(numberStrategy.getLottoNumbers());
    }

    public WinningType matchWinningLotto(Lotto winningLotto, BonusBall bonusBall) {
        return WinningType.of(matchCount(winningLotto), matchBonus(bonusBall));
    }

    public long matchCount(Lotto winningLotto) {
        return winningLotto.winningCount(lottoNumbers);
    }

    private long winningCount(List<LottoNumber> lottoNumbers) {
        return this.lottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private boolean matchBonus(BonusBall bonusBall) {
        return lottoNumbers.contains(bonusBall.getLottoNumber());
    }

    public boolean containLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
