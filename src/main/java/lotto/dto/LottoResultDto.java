package lotto.dto;

import lotto.domain.winning.EarningRate;
import lotto.domain.winning.LottoWinningAmount;
import lotto.domain.winning.LottoWinningResult;
import lotto.domain.PurchaseAmount;

import java.util.Map;

public class LottoResultDto {
    private LottoWinningResult lottoWinningResult;
    private Double earningRate;

    private LottoResultDto(LottoWinningResult lottoWinningResult, PurchaseAmount purchaseAmount) {
        this.lottoWinningResult = lottoWinningResult;
        this.earningRate = EarningRate.of(lottoWinningResult.getTotalWinningAmount(), purchaseAmount.getUsedPurchaseAmount()).get();
    }

    public static LottoResultDto of(LottoWinningResult lottoWinningResult, PurchaseAmount purchaseAmount) {
        return new LottoResultDto(lottoWinningResult, purchaseAmount);
    }

    public LottoWinningResult getWinningResult() {
        return lottoWinningResult;
    }

    public Double getEarningRate() {
        return earningRate;
    }
}
