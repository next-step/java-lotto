package lotto;

import java.util.Scanner;

public class InputView {
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private Scanner scanner = new Scanner(System.in);
    private int purchaseAmount;

    public InputView() {
        System.out.println("구매액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public InputView(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("구매 금액은 최소 천원 이상이어야 합니다");
        }
    }

    public int getPurchaseCount() {
        return purchaseAmount / MIN_PURCHASE_AMOUNT;
    }

}
