package lotto.domain.money;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @Test
    void create() {
        Money money = new Money(1000);

        Assertions.assertAll(
                () -> assertThat(money).isEqualTo(new Money(1000))
        );
    }

    @Test
    void valid() {
        assertThatThrownBy(() -> new Money(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void divide_money() {
        Money money = new Money(10000);

        assertThat(money.divideValue(new Money(1000).money())).isEqualTo(10);
    }

    @Test
    void add_money() {
        Money money = new Money(10000);

        assertThat(money.add(3000)).isEqualTo(new Money(13000));
    }

    @Test
    void multiply_money() {
        Money money = new Money(1000);

        assertThat(money.multiply(3)).isEqualTo(new Money(3000));
    }
}
