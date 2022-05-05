package lotto.domain;

import lotto.constant.MatchResult;

import java.util.Optional;

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

    public Optional<MatchResult> findMatchResult() {
        return Optional.ofNullable(matchResult);
    }

    @Override
    public String toString() {
        return lottoMarkingNumbers.toString();
    }
}
