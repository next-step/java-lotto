package lotto;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class Application {

    public static void main(String args[]) {
        PurchaseAmount purchaseAmount = InputView.getPurchaseAmount();
    }
}
