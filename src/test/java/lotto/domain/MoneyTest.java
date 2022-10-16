package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @Test
    void create() {
        Money money = new Money(1000);

        assertThat(money).isEqualTo(new Money(1000));
    }

    @Test
    void valid() {
        assertThatThrownBy(() -> new Money(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void divide_money() {
        Money money = new Money(10000);

        assertThat(money.divide(new Money(1000))).isEqualTo(10);
    }

    @Test
    void add_money() {
        Money actual = new Money(10000);
        actual.add(new Money(3000));

        assertThat(actual).isEqualTo(new Money(13000));
    }

    @Test
    void multiply_money() {
        Money actual = new Money(1000);
        actual.multiply(3);

        assertThat(actual).isEqualTo(new Money(3000));
    }
}
