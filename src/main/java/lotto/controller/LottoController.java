package lotto.controller;

import lotto.domain.LottoCount;
import lotto.domain.LottoSeller;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputview;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputview = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = inputView.inputPurchaseAmount();
        LottoCount lottoCount = LottoCount.from(purchaseAmount);
        outputview.printLottoCount(lottoCount);
        LottoSeller lottoSeller = new LottoSeller(lottoCount);
        Lottos lottos = lottoSeller.generateLottos();
        outputview.printLottos(lottos);
    }
}
