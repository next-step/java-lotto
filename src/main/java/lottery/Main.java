package lottery;

import lottery.domain.PurchasePrice;
import lottery.view.InputView;

public class Main {

    public static void main(String[] args) {
        PurchasePrice purchasePrice = new PurchasePrice(InputView.getPurchasePrice());
    }
}
