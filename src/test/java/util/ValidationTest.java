package util;

import org.junit.Test;

import static util.Validation.validatePurchaseAmount;

public class ValidationTest {

    @Test(expected = RuntimeException.class)
    public void 구입금액이_음수값이면_오류발생() {
        int purchaseAmount = -1;

        validatePurchaseAmount(purchaseAmount);
    }
}