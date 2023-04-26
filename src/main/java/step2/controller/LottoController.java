package step2.controller;

import step2.domain.LottoService;
import step2.domain.LottoStoreService;
import step2.domain.strategy.LottoStrategy;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoController {
    public static void main(String[] args) {

        int purchaseAmount = InputView.askPurchaseAmount();

        int lottoCount = LottoStoreService.createLottoStoreService()
                .getLotto(new LottoStrategy(), purchaseAmount);
        OutputView.outPut(lottoCount);

        LottoService.createLottoService();


    }
}
