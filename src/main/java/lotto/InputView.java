package lotto;

import java.util.Scanner;

public class InputView {
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private Scanner scanner = new Scanner(System.in);
    private int purchaseAmount;
    private int manualCount;

    public InputView() {
        System.out.println("구매액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = scanner.nextInt();
        validateManualCount(manualCount);
        this.manualCount = manualCount;

    }

    public InputView(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public InputView(int purchaseAmount, int manualCount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        validateManualCount(manualCount);
        this.manualCount = manualCount;
    }

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("구매 금액은 최소 천원 이상이어야 합니다");
        }
    }

    public void validateManualCount(int manualCount) {
        if (manualCount > getPurchaseCount()) {
            throw new IllegalArgumentException("구매 금액보다 수동으로 구매할 로또금액이 큽니다");
        }
    }

    public int getPurchaseCount() {
        return purchaseAmount / MIN_PURCHASE_AMOUNT;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutomaticCount() {
        return getPurchaseCount() - manualCount;
    }
}
