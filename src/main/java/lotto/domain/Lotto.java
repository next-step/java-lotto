package lotto.domain;

import lotto.constant.MatchResult;

public class Lotto {

    private MatchResult matchResult;
    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void confirm(LottoNumbers winningNumbers) {
        int matchCount = lottoNumbers.matchCount(winningNumbers);
        this.matchResult = MatchResult.findByMatchCount(matchCount);
    }

    public MatchResult findMatchResult() {
        return matchResult;
    }

    public LottoNumbers lottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
