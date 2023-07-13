package lottogame.console.purchase;

import lottogame.console.util.LocalScanner;
import lottogame.controller.purchase.spi.PurchaseInputer;

public class ConsolePurchaseInputer implements PurchaseInputer {

    @Override
    public int inputMoney() {
        LocalScanner localScanner = LocalScanner.getInstance();
        System.out.println("구입금액을 입력해 주세요.");
        return localScanner.nextInt();
    }
}
