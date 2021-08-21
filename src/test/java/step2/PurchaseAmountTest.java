package step2;

import org.junit.jupiter.api.Test;
import step2.model.PurchaseAmount;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PurchaseAmountTest {
    @Test
    public void 구매금액_null_빈문자() {
        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  new PurchaseAmount(""));

        exception = assertThrows(IllegalArgumentException.class,
                () ->  new PurchaseAmount(null));
    }

    @Test
    public void 구매금액_숫자가아님() {
        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  new PurchaseAmount("test"));
    }

    @Test
    public void 구매금액_1000미만() {
        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  new PurchaseAmount("999"));
    }

    @Test
    public void 구매갯수() {
        //when
        PurchaseAmount purchaseAmount = new PurchaseAmount("1000");
        int lottoCnt = purchaseAmount.getLottoCount();

        //then
        assertThat(lottoCnt).isEqualTo(1);
    }
}
