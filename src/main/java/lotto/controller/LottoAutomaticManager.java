package lotto.controller;

import lotto.model.LottoSale;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoAutomaticManager {

    public void start() {
        // 입력
        String purchaseAmount = InputView.inputAmount();

        LottoSale lottoSale = new LottoSale();

        int saleCount = lottoSale.sale(purchaseAmount);

        ResultView.printSaleResult(saleCount);
        


    }
}
