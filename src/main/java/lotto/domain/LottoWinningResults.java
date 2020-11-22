package lotto.domain;

import java.util.*;

public class LottoWinningResults {

    private final List<LottoWinningResult> lottoWinningResults;

    public LottoWinningResults(List<LottoWinningResult> lottoWinningResults) {
        this.lottoWinningResults = lottoWinningResults;
    }

    public List<LottoWinningResult> getLottoWinningResults() {
        return lottoWinningResults;
    }
}
