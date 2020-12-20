package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        int money = InputView.requestPurchaseAmount();

        LottoShop lottoShop = new LottoShop();
        Lottos purchasedLotto = lottoShop.getLottos(money);

        ResultView.showPurchasedLottos(purchasedLotto);

        Lotto winNumbers = new Lotto(InputView.requestLastWinNumbers());
        LottoNumber bonusNumber = LottoNumber.of(InputView.requestBonusNumber());

        WinResult winResults = new WinResult(money, purchasedLotto, winNumbers, bonusNumber);

        ResultView.showResults(winResults);
    }
}
