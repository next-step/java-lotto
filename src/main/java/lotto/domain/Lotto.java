package lotto.domain;

import lotto.constant.Rank;

public class Lotto {

    private Rank rank;
    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void confirm(LottoNumbers winningNumbers) {
        int matchCount = lottoNumbers.matchCount(winningNumbers);
        this.rank = Rank.valueOf(matchCount);
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
