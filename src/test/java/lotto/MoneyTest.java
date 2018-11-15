package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void 구매수량계산() {
        Money money = new Money(2000);
        int result = money.getQuntity();

        assertThat(result).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 최소단위미만() {
        Money money = new Money(5);
        money.getQuntity();
    }
}