package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AmountTest {
    @Test
    void create() {
        final Amount amount = new Amount(10000);

        assertThat(amount).isEqualTo(new Amount(10000));
    }

    @Test
    void divideWithDecimalTest() {
        final double result = new Amount(2000).divide(new Amount(1000));

        assertThat(result).isEqualTo(2.00);
    }
}