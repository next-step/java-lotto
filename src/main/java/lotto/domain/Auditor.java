package lotto.domain;

import lotto.exception.ManualPurchaseExceedException;
import lotto.exception.MinimumPurchaseShortageException;

public class Auditor {
    public static void minimumPurchaseCountValidate(int count) {
        if (count <= 0) {
            throw new MinimumPurchaseShortageException();
        }
    }

    public static void manualPurchaseValidation(int totalPurchaseCount, int manualPurchaseCount) {
        if (totalPurchaseCount < manualPurchaseCount) {
            throw new ManualPurchaseExceedException();
        }
    }
}
