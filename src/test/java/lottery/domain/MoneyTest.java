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
    public void test_덧셈() {
        Money money = new Money(1000);

        assertThat(money.add(1000))
                .isEqualTo(new Money(2000));
    }

    @Test
    public void test_곱셈() {
        Money money = new Money(1000);

        assertThat(money.times(14))
                .isEqualTo(new Money(14000));
    }

    @Test
    public void test_나눗셈() {
        Money money = new Money(14000);

        assertThat(money.divide(1000))
            .isEqualTo(new Money(14));
    }

    @Test(expected = ArithmeticException.class)
    public void test_0으로_나눔() {
        Money money = new Money(14000);

        money.divide(0);
    }
}