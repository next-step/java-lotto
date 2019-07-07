package lotto.dto;

import lotto.common.PositiveNumber;
import lotto.domain.winning.EarningRate;
import lotto.domain.winning.LottoWinningResult;

public class LottoResultDto {
    private LottoWinningResult lottoWinningResult;
    private EarningRate earningRate;

    private LottoResultDto(LottoWinningResult lottoWinningResult, PositiveNumber purchaseCount) {
        this.lottoWinningResult = lottoWinningResult;
        this.earningRate = EarningRate.of(PositiveNumber.of(lottoWinningResult.getTotalWinningAmount()), purchaseCount);
    }

    public static LottoResultDto of(LottoWinningResult lottoWinningResult, PositiveNumber purchaseCount) {
        return new LottoResultDto(lottoWinningResult, purchaseCount);
    }

    public LottoWinningResult getWinningResult() {
        return lottoWinningResult;
    }

    public double getEarningRate() {
        return earningRate.get();
    }
}
