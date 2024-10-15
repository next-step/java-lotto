package lotto.entity;

import java.math.BigDecimal;
import java.util.List;

public class LottoResult {

    private final List<WinningResult> winningResults;
    private final BigDecimal rate;

    public LottoResult(BigDecimal rate, List<WinningResult> winningResults) {
        this.rate = rate;
        this.winningResults = winningResults;
    }

    public BigDecimal getRate() {
        return this.rate;
    }

    public List<WinningResult> getWinningResults() {
        return this.winningResults;
    }
}
