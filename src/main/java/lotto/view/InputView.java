package lotto.view;

import lotto.exception.InputValueException;

import java.util.Scanner;

public final class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static int MIN_PURCHASE_AMOUNT = 1000;

    private InputView() {
    }

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();

        validatePurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT) {
            throw new InputValueException();
        }
    }
}
