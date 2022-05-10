package lotto.domain;

import lotto.constant.Rank;

public class Lotto {

    private Rank rank;
    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void confirm(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        int matchCount = lottoNumbers.matchCount(winningNumbers);
        boolean matchBonus = lottoNumbers.isContain(bonusNumber);
        rank = Rank.valueOf(matchCount, matchBonus);
    }

    public Rank findMatchResult() {
        return rank;
    }

    public LottoNumbers lottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
