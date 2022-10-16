package lotto.domain.money;

import lotto.domain.Money.ImmutableMoney;
import lotto.domain.Money.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @Test
    void create() {
        Money money = new Money(1000);

        Assertions.assertAll(
                () -> assertThat(money).isEqualTo(new Money(1000)),
                () -> assertThat(money).isEqualTo(new ImmutableMoney(1000))
        );
    }

    @Test
    void valid() {
        assertThatThrownBy(() -> new Money(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void divide_money() {
        Money money = new Money(10000);

        assertThat(money.divide(new Money(1000).value())).isEqualTo(10);
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
