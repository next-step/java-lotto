package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoAutomaticManager {

    public void start() {

        String purchaseAmount = InputView.inputAmount();
        LottoSale lottoSale = new LottoSale(purchaseAmount, new RandomLottoStrategy());
        ResultView.printSaleResult(lottoSale, lottoSale.getNumberOfLottos());

        String winningNumber = InputView.inputWinningNumbers();
        LottoCheck lottoCheck = new LottoCheck(winningNumber, lottoSale.getLottos());
        LottoRevenueCheck revenueCheck = new LottoRevenueCheck(lottoCheck.getWinLottos());
        ResultView.printWinningStatisticsResult(lottoCheck.getWinLottos(), revenueCheck.getRevenueRatio(purchaseAmount));

    }
}
