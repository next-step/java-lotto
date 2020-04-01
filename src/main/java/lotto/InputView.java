package lotto;

import java.util.Scanner;

public class InputView {
    private static final int MIN_PURCHASE_AMOUNT = LottoRule.MIN_PURCHASE_AMOUNT.getValue();

    private static InputView inputView = new InputView();
    private static Scanner scanner = new Scanner(System.in);

    public int enterPurchaseAmount() {
        System.out.println("구매액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        validatePurchaseAmount(purchaseAmount);
        return getPurchaseCount(purchaseAmount);
    }

    public int enterManualCount(int purchaseCount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = scanner.nextInt();
        validateManualCount(purchaseCount, manualCount);
        return manualCount;
    }

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("구매 금액은 최소 천원 이상이어야 합니다");
        }
    }

    public void validateManualCount(int purchaseCount, int manualCount) {
        if (manualCount > purchaseCount) {
            throw new IllegalArgumentException("구매 금액보다 수동으로 구매할 로또금액이 큽니다");
        }
    }

    public int getPurchaseCount(int purchaseAmount) {
        return purchaseAmount / MIN_PURCHASE_AMOUNT;
    }

    public int getAutomaticCount(int purchaseCount, int manualCount) {
        return purchaseCount - manualCount;
    }

    public String purchaseLottoTicketInfo(int manualCount, int automaticCount) {
        return "수동으로 " + manualCount + "장, 자동으로 " + automaticCount + "개를 구매했습니다.";
    }

    public static InputView getInputView() {
        return inputView;
    }
}
