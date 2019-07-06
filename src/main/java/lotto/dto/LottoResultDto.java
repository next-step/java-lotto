package lotto.dto;

import lotto.common.PositiveNumber;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.winning.EarningRate;
import lotto.domain.winning.LottoWinningResult;

public class LottoResultDto {
    private LottoWinningResult lottoWinningResult;
    private Double earningRate;

    private LottoResultDto(LottoWinningResult lottoWinningResult, PositiveNumber purchaseCount) {
        this.lottoWinningResult = lottoWinningResult;
        this.earningRate = EarningRate.of(lottoWinningResult.getTotalWinningAmount(), LottoTicket.PRICE * purchaseCount.get()).get();
    }

    public static LottoResultDto of(LottoWinningResult lottoWinningResult, PositiveNumber purchaseCount) {
        return new LottoResultDto(lottoWinningResult, purchaseCount);
    }

    public LottoWinningResult getWinningResult() {
        return lottoWinningResult;
    }

    public Double getEarningRate() {
        return earningRate;
    }
}
