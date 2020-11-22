package lotto.domain;

import java.util.Objects;

public class LottoWinningResult {

    private final LottoResult lottoResult;
    private int count = 0;

    public LottoWinningResult(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public LottoWinningResult(LottoResult lottoResult,int count) {
        this.lottoResult = lottoResult;
        this.count = count;
    }

    public LottoWinningResult incrementOfCount() {
        this.count++;
        return this;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinningResult that = (LottoWinningResult) o;
        return count == that.count &&
                lottoResult == that.lottoResult;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResult, count);
    }
}
