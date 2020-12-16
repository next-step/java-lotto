package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.WinResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int money = InputView.requestPurchaseAmount();

        LottoShop lottoShop = new LottoShop();
        List<Lotto> purchasedLotto = lottoShop.getLottos(money);

        ResultView.showPurchasedLottos(purchasedLotto);

        String winNumbers = InputView.requestLastWinNumbers();
        WinResult winResults = new WinResult(purchasedLotto, winNumbers, money);

        ResultView.showResults(winResults);
    }
}
