package lotto.controller;

import lotto.model.LottoRevenueCheck;
import lotto.model.LottoSale;
import lotto.model.LottoWinCheck;
import lotto.model.RandomLottoStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoAutomaticManager {

    public void start() {

        String purchaseAmount = InputView.inputAmount();
        LottoSale lottoSale = new LottoSale(purchaseAmount, new RandomLottoStrategy());
        ResultView.printSaleResult(lottoSale, lottoSale.getNumberOfLottos());

        String winningNumber = InputView.inputWinningNumbers();
        LottoWinCheck lottoWinCheck = new LottoWinCheck(winningNumber, lottoSale.getLottos());
        LottoRevenueCheck revenueCheck = new LottoRevenueCheck(lottoWinCheck.getWinLottos());
        ResultView.printWinningStatisticsResult(lottoWinCheck.getWinLottos(), revenueCheck.getRevenueRatio(purchaseAmount));

    }
}
