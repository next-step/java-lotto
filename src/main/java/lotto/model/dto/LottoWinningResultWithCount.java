package lotto.model.dto;

import lotto.model.LottoWinningResult;

public class LottoWinningResultWithCount {
    private final LottoWinningResult lottoWinningResult;
    private final long count;

    public LottoWinningResultWithCount(final LottoWinningResult lottoWinningResult, final long count) {
        this.lottoWinningResult = lottoWinningResult;
        this.count = count;
    }

    public int getMatchCount() {
        return lottoWinningResult.getMatchCount();
    }

    public long getPrice() {
        return lottoWinningResult.getPrice();
    }

    public long getCount() {
        return count;
    }

    public LottoWinningResult getLottoWinningResult() {
        return lottoWinningResult;
    }
}
