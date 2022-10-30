package step2.controller;

import step2.domain.LottoRank;
import step2.domain.Lottos;
import step2.domain.PurchasePrice;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

public class LottoController {

    public void start() {
        PurchasePrice purchasePrice = InputView.purchasePriceInput();
        Lottos lottos = new Lottos(purchasePrice);
        purchaseOutput(lottos);

        List<LottoRank> lottoRanks = lottos.lottoRanks(InputView.winningNumbers());
        rewardOutput(lottoRanks);

        yieldOutput(lottoRanks, purchasePrice);
    }

    private void purchaseOutput(Lottos lottos) {
        OutputView.lottoPurchaseOutput(lottos);
    }

    private void rewardOutput(List<LottoRank> lottoRanks) {
        OutputView.lottoRewardOutput(lottoRanks);
    }

    private void yieldOutput(List<LottoRank> lottoRanks, PurchasePrice purchasePrice) {
        OutputView.lottoYieldOutput(lottoRanks, purchasePrice);
    }
}
