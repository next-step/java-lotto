package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoCountSummary;
import lotto.domain.LottoNumber;
import lotto.domain.LottoSeller;
import lotto.domain.Lottos;
import lotto.domain.ManualLottoCount;
import lotto.domain.PrizeSummary;
import lotto.domain.Profit;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningCombo;
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
        LottoCountSummary lottoCountSummary = createLottoCountSummary(purchaseAmount);

        Lottos totalLottos = createTotalLottos(lottoCountSummary);

        outputview.printLottoCountSummary(lottoCountSummary);
        outputview.printLottos(totalLottos);

        WinningCombo winningCombo = createWinningCombo();
        PrizeSummary prizeSummary = totalLottos.getPrizeSummary(winningCombo);
        outputview.printPrizeSummary(prizeSummary);

        Profit profit = Profit.of(purchaseAmount, prizeSummary);
        outputview.printProfit(profit);
    }

    private LottoCountSummary createLottoCountSummary(PurchaseAmount purchaseAmount) {
        LottoCount totalLottoCount = LottoCount.fromPurchaseAmount(purchaseAmount);
        ManualLottoCount manulLottoCount = inputView.inputManualLottoCount(totalLottoCount);
        return LottoCountSummary.of(totalLottoCount, manulLottoCount);
    }

    private Lottos createTotalLottos(LottoCountSummary lottoCountSummary) {
        Lottos manualLottos = inputView.inputManualLottos(lottoCountSummary);
        Lottos autoLottos = generateAutoLottos(lottoCountSummary);
        return manualLottos.mergeLottos(autoLottos);
    }

    private WinningCombo createWinningCombo() {
        Lotto winningLotto = inputView.inputWinningLotto();
        LottoNumber bonusBall = inputView.inputBonusBall();
        return WinningCombo.of(winningLotto, bonusBall);
    }

    private Lottos generateAutoLottos(LottoCountSummary lottoCountSummary) {
        LottoSeller lottoSeller = LottoSeller.from(lottoCountSummary);
        return lottoSeller.generateLottos();
    }
}
