package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class PurchaseTest {

    @Test
    public void 구매할_lotto_매수() {
        String money = "1000";
        Purchase purchase = new Purchase(money);
        int result = purchase.purchaseQuantity();
        assertThat(result).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 한장가격보다_낮은금액() {
        String money = "500";
        Purchase purchase = new Purchase(money);
        int result = purchase.purchaseQuantity();
    }

    @Test
    public void 결과에따른수익률() {
        String money = "5000";
        Purchase purchase = new Purchase(money);

    }
}