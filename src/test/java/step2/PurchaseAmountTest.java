package step2;

import org.junit.jupiter.api.Test;
import step2.model.PurchaseAmount;

import static org.assertj.core.api.Assertions.*;

public class PurchaseAmountTest {
    @Test
    public void 구매금액_null_빈문자() {
        assertThatThrownBy(() -> new PurchaseAmount(""))
                        .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new PurchaseAmount(null))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구매금액_숫자가아님() {
        assertThatThrownBy(() -> new PurchaseAmount("test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구매금액_1000미만() {
        assertThatThrownBy(() -> new PurchaseAmount("999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구매갯수_null_빈문자() {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount("10000");

        //then
        assertThatThrownBy(() -> purchaseAmount.calcPurchaseAmount(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> purchaseAmount.calcPurchaseAmount(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구매갯수_숫자아님() {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount("10000");

        //then
        assertThatThrownBy(() -> purchaseAmount.calcPurchaseAmount("test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또구매후_갯수만큼_구매금액에서_차감() {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount("10000");

        //when
        PurchaseAmount leftAmount = purchaseAmount.calcPurchaseAmount("2");

        //then
        assertThat(leftAmount).isEqualTo(new PurchaseAmount("8000"));
    }

    @Test
    public void 구매금액_초과_구매() {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount("10000");

        //then
        assertThatThrownBy(() -> purchaseAmount.calcPurchaseAmount("11"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
