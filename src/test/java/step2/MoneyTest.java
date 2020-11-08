package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    void lessThen() {
        assertThat(Money.of(100).lessThan(Money.of(200))).isTrue();
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
}
