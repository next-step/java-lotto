package lotto.domain;


import lotto.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(LottoNumberStrategy numberStrategy) {
        lottoNumbers = new ArrayList<>(numberStrategy.getLottoNumbers());
    }

    public WinningType matchWinningLotto(WinningLotto winningLotto) {
        return WinningType.of(winningLotto.matchCount(lottoNumbers), winningLotto.matchBonus(lottoNumbers));
    }

    public long winningCount(List<LottoNumber> lottoNumbers) {
        return this.lottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public boolean containLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
