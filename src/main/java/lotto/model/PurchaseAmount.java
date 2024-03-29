package lotto.model;

import lotto.exception.PurchaseException;

public class PurchaseAmount {
    private static final int LOTTO_PURCHASE_UNIT = 1_000;
    public static final String INVALID_PURCHASE_AMOUNT = "구입하신 수동 로또의 개수가 전체 로또 개수보다 많습니다.";
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public int getNumberOfTotalLottos() {
        return this.purchaseAmount / LOTTO_PURCHASE_UNIT;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PURCHASE_UNIT) {
            throw new IllegalArgumentException(LOTTO_PURCHASE_UNIT + "원 이상부터 로또 구매가 가능합니다.");
        }
    }

    public void isValidPurchaseNumberOfManualLotto(int numberOfManualLottos) {
        if (numberOfManualLottos > getNumberOfTotalLottos()) {
            throw new PurchaseException("구입하신 수동 로또의 개수가 전체 로또 개수보다 많습니다.");
        }
    }
}
