package lotto.utils;

import lotto.domain.PurchaseAmount;

public class DivisionUtil {
    private static final int THOUSAND = 1000;

    private DivisionUtil() {
    }

    public static int divideByThousand(PurchaseAmount purchaseAmount) {
        return purchaseAmount.purchaseAmount() / THOUSAND;
    }
}
