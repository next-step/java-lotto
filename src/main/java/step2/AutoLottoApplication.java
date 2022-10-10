package step2;

import step2.view.InputView;
import step2.view.OutputView;

public class AutoLottoApplication {
    public static void main(String[] args) {
        OutputView.printPriceNotification();
        int price = InputView.inputPrice();
        OutputView.printPurchaseResult(price);
    }
}
