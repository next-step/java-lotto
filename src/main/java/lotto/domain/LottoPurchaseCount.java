package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class LottoPurchaseCount {

    public static final String REQUESTED_AMOUNT_CANNOT_BE_BIGGER_THAN_PURCHASE_AMOUNT = "구매하고자 하는 금액이 구입 금액보다 클 수 없습니다.";
    private final int requestPurchaseAmount;
    private final int requestManuallyPurchaseCount;

    public LottoPurchaseCount(int requestPurchaseAmount, int requestManuallyPurchaseCount) {
        this.requestPurchaseAmount = requestPurchaseAmount;
        this.requestManuallyPurchaseCount = requestManuallyPurchaseCount;
        validateRequestManuallyPurchaseCount();
    }

    private void validateRequestManuallyPurchaseCount() {
        if (requestManuallyPurchaseCount * LOTTO_PRICE > requestPurchaseAmount) {
            throw new IllegalArgumentException(REQUESTED_AMOUNT_CANNOT_BE_BIGGER_THAN_PURCHASE_AMOUNT);
        }
    }

    public int getAutomaticallyPurchaseCount() {
        int automaticallyPurchaseAmount = requestPurchaseAmount - (requestManuallyPurchaseCount * LOTTO_PRICE);
        return (int) automaticallyPurchaseAmount / LOTTO_PRICE;
    }

    public int getRequestManuallyPurchaseCount() {
        return requestManuallyPurchaseCount;
    }
}
