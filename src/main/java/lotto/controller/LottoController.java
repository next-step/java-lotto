package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.HashMap;

public class LottoController {
    public static void main(String[] args) {
        Integer purchaseAmount = Input.inputPurchaseAmount();
        int manualLottoCount = Input.inputManualLottoCount();

        LottosBuyer lottosBuyer = new LottosBuyer(purchaseAmount, manualLottoCount);
        Lottos manualLottos = Input.inputManualLottos(manualLottoCount);
        Lottos randomLottos = lottosBuyer.buyRandomLottos();
        Lottos totalLottos = lottosBuyer.getTotalLottos(manualLottos, randomLottos);
        Output.viewPurchasedLotto(totalLottos);

        String winningLottoString = Input.inputWinningNumbers();
        LottoNumber bonus = Input.inputBonusBall();
        WinningLotto winningLotto = WinningLotto.ofStringAndBonusBall(winningLottoString, bonus);
        HashMap<Prize, Integer> record = LottosRecord.makeRecord(totalLottos, winningLotto, bonus);
        Double profit = new Double(totalLottos.getTotalProfit(winningLotto, bonus));
        Double profitRate = LottosRecord.calculateProfitRate(profit, purchaseAmount);
        LottosRecord lottosRecord = LottosRecord.of(record, profitRate);

        Output.viewResult(lottosRecord);
    }
}
