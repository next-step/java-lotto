package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public LottoController() {
    }
    public void run(){
        LottoGenerator lottoGenerator = new LottoGenerator(InputView.getPurchasePrice());
        ResultView.printPurchaseLottoCount(lottoGenerator.getLottos());
    }
}
