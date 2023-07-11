package lottogame.console.purchase;

import lottogame.controller.purchase.spi.PurchaseInputer;

public class ConsolePurchaseInputer implements PurchaseInputer {

    @Override
    public int inputMoney() {
        return 1000;
    }
}
