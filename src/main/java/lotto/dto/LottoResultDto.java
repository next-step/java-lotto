package lotto.dto;

import lotto.domain.winning.EarningRate;
import lotto.domain.winning.LottoWinningAmount;
import lotto.domain.winning.LottoWinningResult;
import lotto.domain.PurchaseAmount;

import java.util.Map;

public class LottoResultDto {
    private Map<LottoWinningAmount, Long> winningResultMap;
    private Double earningRate;

    private LottoResultDto(LottoWinningResult lottoWinningResult, PurchaseAmount purchaseAmount) {
        winningResultMap = lottoWinningResult.getWinningResult();
        earningRate = EarningRate.of(lottoWinningResult.getTotalWinningAmount(), purchaseAmount.getUsedPurchaseAmount()).get();
    }

    public static LottoResultDto of(LottoWinningResult lottoWinningResult, PurchaseAmount purchaseAmount) {
        return new LottoResultDto(lottoWinningResult, purchaseAmount);
    }

    public Map<LottoWinningAmount, Long> getWinningResultMap() {
        return winningResultMap;
    }

    public Double getEarningRate() {
        return earningRate;
    }
}
