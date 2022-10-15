package lotto.view.input;

import java.util.Scanner;

public class PaymentAmountInputView {

    public static int getPaymentAmount(Scanner scanner) {
        System.out.println("구입금액을 입력해주세요.");

        int paymentAmount = scanner.nextInt();
        scanner.nextLine();
        return paymentAmount;
    }
}
