package lottery.domain;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void test_동일성() {
        Money money = new Money(1000);
        assertThat(money)
                .isEqualTo(new Money(1000));
        assertThat(money)
                .hasSameHashCodeAs(new Money(1000));
    }

    @Test
    public void test_나누기() {
        Money money = new Money(14000);
        assertThat(money.divide(1000))
            .isEqualTo(14);
    }
}