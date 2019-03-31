package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    private Money money;

    @Test(expected = IllegalArgumentException.class)
    public void 금액_천원이하() {
        this.money = new Money(900);
    }

    @Test
    public void 금액_천원이상() {
        this.money = new Money(1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_천원으로_두장구매() {
        new Money(1000).checkPurchase(2);
    }

    @Test
    public void 로또_천원으로_한장구매() {
        new Money(1000).checkPurchase(1);
    }

    @Test
    public void 로또_구매후_남은_장수() {
        assertThat(new Money(1000).calcBalance(1)).isEqualTo(0);
        assertThat(new Money(2000).calcBalance(1)).isEqualTo(1);
    }


}
