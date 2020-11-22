package lotto.domain;

import java.util.*;

public class LottoWinningResults {

    private final Set<LottoWinningResult> lottoWinningResults;

    public LottoWinningResults(Set<LottoWinningResult> lottoWinningResults) {
        this.lottoWinningResults = lottoWinningResults;
    }

    public Set<LottoWinningResult> getLottoWinningResults() {
        return lottoWinningResults;
    }
}
