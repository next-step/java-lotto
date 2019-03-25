package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void 구매할_lotto_매수() {
        String money = "1000";
        Money purchase = new Money(money);
        int result = purchase.purchaseQuantity();
        assertThat(result).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 한장가격보다_낮은금액() {
        String money = "500";
        Money purchase = new Money(money);
        int result = purchase.purchaseQuantity();
    }
}