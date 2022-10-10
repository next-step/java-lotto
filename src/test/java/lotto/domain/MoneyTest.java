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
    void divide() {
        Money money = new Money(10000);

        assertThat(money.divide(1000)).isEqualTo(10);
    }
}
