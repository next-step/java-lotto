package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    void dividedByTest() throws Exception {
        Money numerator = Money.of(10000L);
        Money denominator = Money.of(1000L);
        assertThat(numerator.dividedBy(denominator)).isEqualTo(10);
    }

    @Test
    void multiplyTest() throws Exception {
        assertThat(Money.of(100L).multiply(3L)).isEqualTo(Money.of(300L));
    }
}
