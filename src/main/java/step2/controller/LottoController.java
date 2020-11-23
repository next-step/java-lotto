package step2.controller;

import step2.domain.Lotto;
import step2.domain.LottoStore;
import step2.domain.Person;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        ResultView.printPurchasePrice();
        int purchasePrice = InputView.inputPurchasePrice();

        LottoStore lottoStore = new LottoStore();
        int purchaseLottoCount = lottoStore.getPurchaseLottoCount(purchasePrice);

        ResultView.printPurchaseCount(purchaseLottoCount);

        Person person = new Person();

        for (int i = 0; i < purchaseLottoCount; i++) {
            Lotto lotto = lottoStore.getLottoNumbers();
            person.addLotto(lotto);
            ResultView.printLottoNumbers(lotto.getNumbers());
        }
    }
}
