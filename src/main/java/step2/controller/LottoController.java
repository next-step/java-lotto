package step2.controller;

import step2.domain.Lotto;
import step2.domain.LottoStore;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        ResultView.printPurchasePrice();
        int purchasePrice = InputView.inputPurchasePrice();

        LottoStore lottoStore = new LottoStore();
        int purchaseLottoCount = lottoStore.getPurchaseLottoCount(purchasePrice);

        ResultView.printPurchaseCount(purchaseLottoCount);

        Lotto lotto = new Lotto();
        System.out.println(lotto.getLottoNumbers().toString());
    }
}
