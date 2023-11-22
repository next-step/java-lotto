package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoSeller;
import lotto.domain.Lottos;
import lotto.domain.PrizeSummary;
import lotto.domain.Profit;
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
        Lotto winningLotto = inputView.inputWinningLotto();
        PrizeSummary prizeSummary = lottos.getPrizeSummary(winningLotto);
        outputview.printPrizeSummary(prizeSummary);
        Profit profit = Profit.of(purchaseAmount, prizeSummary);
        outputview.printProfit(profit);
    }
}
