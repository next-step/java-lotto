package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    void add() {
        Money money = new Money(0);
        Money other = new Money(1_000L);

        money = money.add(other);

        assertThat(money).isEqualTo(new Money(1_000L));
    }

    @Test
    void divide() {
        Money money = new Money(1_000L);
        Money divider = new Money(500L);

        double actual = money.divide(divider);

        assertThat(actual).isEqualTo(2);
    }

    @Test
    void multiply() {
        Money money = new Money(500L);

        Money actual = money.multiply(2);

        assertThat(actual).isEqualTo(new Money(1_000L));
    }
}