package lotto.domain;

import lotto.constant.MatchResult;

import java.util.Optional;

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

    public Optional<MatchResult> findMatchResult() {
        return Optional.ofNullable(matchResult);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
