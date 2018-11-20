package lotto.model;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyTest {

    @Test
    public void 생성() {
        assertThat(Money.from(15000)).isEqualTo(Money.from(15000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_0원_미만() {
        Money.from(-1000);
    }

    @Test
    public void 구매가능_수량() {
        Money money = Money.from(15000);
        assertThat(money.countOfBuy(1000)).isEqualTo(15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 차감_불가() {
        Money money = Money.from(15000);
        money.deduct(Money.from(20000));
    }

    @Test
    public void 차감() {
        Money money = Money.from(15000);
        money.deduct(Money.from(3000));
        assertThat(money).isEqualTo(Money.from(12000));
    }
}
