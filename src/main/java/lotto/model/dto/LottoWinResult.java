package lotto.model.dto;

import lotto.model.LottoResult;

public class LottoWinResult {
    private final LottoResult lottoResult;
    private final Long count;

    public LottoWinResult(final LottoResult lottoResult, final Long count) {
        this.lottoResult = lottoResult;
        this.count = count;
    }

    public int getMatchCount() {
        return lottoResult.getMatchCount();
    }

    public long getPrice() {
        return lottoResult.getPrice();
    }

    public Long getCount() {
        return count;
    }
}
