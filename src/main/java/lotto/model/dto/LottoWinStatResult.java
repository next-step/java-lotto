package lotto.model.dto;

import lotto.model.LottoResult;

public class LottoWinStatResult {
    private final LottoResult lottoResult;
    private final long count;

    public LottoWinStatResult(final LottoResult lottoResult, final long count) {
        this.lottoResult = lottoResult;
        this.count = count;
    }

    public int getMatchCount() {
        return lottoResult.getMatchCount();
    }

    public long getPrice() {
        return lottoResult.getPrice();
    }

    public long getCount() {
        return count;
    }
}
