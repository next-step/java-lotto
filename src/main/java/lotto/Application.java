package lotto;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PurchaseAmount;
import lotto.domain.Store;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String args[]) {
        Money money = InputView.getPurchaseAmount();
        PurchaseAmount purchaseAmount = Store.buyLotto(money);
        OutputView.printPurchaseLotto(purchaseAmount);
        Lottos lottos = new Lottos(purchaseAmount);
        OutputView.printLottoNumbers(lottos);

    }
}
