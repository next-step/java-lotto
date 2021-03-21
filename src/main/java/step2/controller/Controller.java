package step2.controller;

import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.LottoMoney;
import step2.view.InputView;
import step2.view.ResultView;

public class Controller {

    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void buyLotto() {
        int purchasePrice = inputView.inputPurchasePrice();
        Lottos lottos = new Lottos(purchasePrice);
        resultView.printPurchase(lottos);

        for (Lotto lotto : lottos.getLottos()) {
            resultView.printLottoNumber(lotto);
        }

        String lastWinning = inputView.inputLastLottoNumber();
        resultView.printSameLotto(lottos, lastWinning);
    }
}
