package lottogame.console.purchase;

import java.util.Scanner;
import lottogame.controller.spi.PurchaseInputer;

public class ConsolePurchaseInputer implements PurchaseInputer {

    @Override
    public int inputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }
}
