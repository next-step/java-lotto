package lotto;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PurchaseAMountTest {

    @Test
    public void 천원_미만금액테스트() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(0);
        assertThatIllegalArgumentException()
                .isThrownBy(purchaseAmount::convertAmountToTryLottoCount);
    }
}
