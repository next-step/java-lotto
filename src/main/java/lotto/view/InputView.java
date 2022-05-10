package lotto.view;

import lotto.domain.Money;

import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구매 금액을 입력해주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static Money getPurchaseAmount() {
        printPurchaseAmount();
        return new Money(scanner.nextInt());
    }

    private static void printPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }
}
