package lotto.controller;

import lotto.model.LottoCheck;
import lotto.model.LottoGenerator;
import lotto.model.LottoSale;
import lotto.model.RandomLottoStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoAutomaticManager {

    public void start() {

        String purchaseAmount = InputView.inputAmount();
        LottoSale lottosaletest = new LottoSale(purchaseAmount, new RandomLottoStrategy());
        ResultView.printSaleResultTest(lottosaletest, lottosaletest.getNumberOfLottos());

        String winningNumber = InputView.inputWinningNumbers();
        LottoCheck lottoCheck = new LottoCheck(winningNumber, lottosaletest.getLottos());



    }
}
