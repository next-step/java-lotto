package lotto;

import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.PurchaseMoney;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApp {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        PurchaseMoney purchaseMoney = inputView.inputPurchaseMoney();

        LottoShop lottoShop = new LottoShop();
        Lottos lottos = lottoShop.purchase(purchaseMoney);

        ResultView resultView = new ResultView();
        resultView.printLottos(lottos);
    }
}
