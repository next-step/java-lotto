package lotto;

import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.Store;
import lotto.view.InputView;

public class Application {

    public static void main(String args[]) {
        PurchaseAmount purchaseAmount = InputView.getPurchaseAmount();
        Lottos lottos = new Lottos(Store.buyLotto(purchaseAmount));
    }
}
