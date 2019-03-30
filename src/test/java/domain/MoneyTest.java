package domain;

import org.junit.Test;

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
}
