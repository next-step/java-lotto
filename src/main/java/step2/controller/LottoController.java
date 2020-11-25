package step2.controller;

import step2.domain.Lotto;
import step2.domain.LottoStore;
import step2.domain.Person;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoController {
    public void start() {
        ResultView.printPurchasePrice();
        int purchasePrice = InputView.inputPurchasePrice();

        LottoStore lottoStore = new LottoStore();
        int purchaseLottoCount = lottoStore.getPurchaseLottoCount(purchasePrice);

        ResultView.printPurchaseCount(purchaseLottoCount);

        Person person = new Person();

        for (int i = 0; i < purchaseLottoCount; i++) {
            Lotto lotto = new Lotto(lottoStore.getLottoNumbers());
            person.addLotto(lotto);
            ResultView.printLottoNumbers(lotto.getNumbers());
        }

        ResultView.printWinNumber();
        int[] winNumber = InputView.inputWinNumber();
        int[][] winCounts = person.getWin(winNumber);
        ResultView.printWinCounts(winCounts);

        double totalRevenue = person.getTotalRevenue(purchasePrice, winCounts);
        ResultView.printTotalRevenue(totalRevenue);
    }
}
