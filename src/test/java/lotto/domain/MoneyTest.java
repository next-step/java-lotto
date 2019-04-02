package lotto.domain;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test(expected = IllegalArgumentException.class)
    public void 영보다_작은_금액() {
        // given
        // when
        // then
        Money.from(-1);
    }

    @Test
    public void 덧셈() {
        // given
        final Money money = Money.from(100);

        // when
        final Money result = money.add(money);

        // then
        assertThat(result).isEqualTo(Money.from(200));
    }

    @Test
    public void 뺄셈() {
        // given
        final Money money = Money.from(100);

        // when
        final Money result = money.subtract(money);

        // then
        assertThat(result).isEqualTo(Money.from(0));
    }

    @Test
    public void 곱셈() {
        // given
        final Money money = Money.from(100);
        final int multiplicand = 10;

        // when
        final Money result = money.multiply(multiplicand);

        // then
        assertThat(result).isEqualTo(Money.from(1000));
    }

    @Test
    public void 나눗셈() {
        // given
        final Money money = Money.from(100);

        // when
        final BigDecimal result = money.divide(money);

        // then
        assertThat(result).isEqualTo(BigDecimal.ONE);
    }
}