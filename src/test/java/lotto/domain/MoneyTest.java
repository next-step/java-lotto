package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void create() {
        assertThat(new Money(10_000)).isEqualTo(new Money(10_000));
    }
}
