package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    void longValueTest() {
        assertThat(new Money(10).longValue())
                .isEqualTo(10);
    }

    @Test
    void equalsTest() {
        assertThat(new Money(10))
                .isEqualTo(10);
    }
}