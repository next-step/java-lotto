package lotto.util;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {
    @Test
    void longValueTest() {
        assertThat(new Money(10).longValue())
                .isEqualTo(10);
    }

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void equalsTest() {
        assertThat(new Money(10))
                .isEqualTo(10);
    }
}