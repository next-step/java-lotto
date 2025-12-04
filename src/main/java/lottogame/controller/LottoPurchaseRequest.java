package lottogame.controller;

import java.util.Set;
import lottogame.model.lotto.ManualLottos;
import lottogame.model.price.LottoPurchasePrice;
import lottogame.model.winner.WinnerResult;

public record LottoPurchaseRequest(
        LottoPurchasePrice lottoPurchasePrice,
        ManualLottos manualLottos
) {
    public int calculateAutoLottoCount(int perLottoPrice) {
        int totalLottoCount = this.lottoPurchasePrice.calculateLottoCount(perLottoPrice);
        int manualLottoCount = this.manualLottos.size();

        return totalLottoCount - manualLottoCount;
    }

    public double getRateOfReturn(WinnerResult winnerResult) {
        return this.lottoPurchasePrice.calculateRateOfReturn(winnerResult.sumTotalWinReturn());
    }
}
