package Lotto;

import java.util.Scanner;

public class InputView {

    public Amount InputPurchasingAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String amount = scanner.nextLine();
        scanner.close();
        return new Amount(amount);
    }

}
