package lotto;

import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.WinResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        int money = InputView.requestPurchaseAmount();

        LottoShop lottoShop = new LottoShop();
        Lottos purchasedLotto = lottoShop.getLottos(money);

        ResultView.showPurchasedLottos(purchasedLotto);

        String winNumbers = InputView.requestLastWinNumbers();
        String bonusNumber = InputView.requestBonusNumber();
        
        WinResult winResults = new WinResult(money, purchasedLotto, winNumbers, bonusNumber);

        ResultView.showResults(winResults);
    }
}
