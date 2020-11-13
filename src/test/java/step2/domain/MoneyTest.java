package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    void lessThen() {
        Assertions.assertThat(Money.of(100).lessThan(Money.of(200))).isTrue();
    }

    @Test
    void divide() {
        assertThat(Money.of(1000).divide(Money.of(100))).isEqualTo(10);
    }

    @Test
    void multiply() {
        assertThat(Money.of(1000).multiply(10)).isEqualTo(Money.of(10000));
    }

    @Test
    void subtract() {
        assertThat(Money.of(1000).subtract(Money.of(100))).isEqualTo(Money.of(900));
    }

    @Test
    void equals() {
        assertThat(Money.of(1000).equals(Money.of(1000))).isTrue();
    }

    @Test
    void divideByZero() {
        assertThatThrownBy(() -> Money.of(1000).divide(Money.of(0))) //
                .isInstanceOf(MoneyArithmeticException.class);
    }

    @Test
    void minusMoney() {
        assertThatThrownBy(() -> Money.of(1000).subtract(Money.of(2000))) //
                .isInstanceOf(MoneyArithmeticException.class);
    }

    @Test
    void add() {
        assertThat(Money.of(1000).add(Money.of(2000))).isEqualTo(Money.of(3000));
    }
}
