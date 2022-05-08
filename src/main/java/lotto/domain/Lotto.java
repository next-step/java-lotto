package lotto.domain;

import lotto.constant.MatchResult;

public class Lotto {

    private MatchResult matchResult;
    private final LottoMarkingNumbers lottoMarkingNumbers;

    public Lotto(LottoMarkingNumbers lottoMarkingNumbers) {
        this.lottoMarkingNumbers = lottoMarkingNumbers;
    }

    public void confirm(WinningNumbers winningNumbers) {
        int matchCount = lottoMarkingNumbers.matchCount(winningNumbers);
        this.matchResult = MatchResult.findByMatchCount(matchCount);
    }

    public MatchResult findMatchResult() {
        return matchResult;
    }

    public LottoMarkingNumbers lottoMarkingNumbers() {
        return lottoMarkingNumbers;
    }

    @Override
    public String toString() {
        return lottoMarkingNumbers.toString();
    }
}
