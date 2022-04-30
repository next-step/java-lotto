package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    void priceShouldBePositive() {
        assertThat(new Money(14000).price).isPositive();
    }

    @Test
    void priceLessThan1000GetsError() {
        assertThatThrownBy(() -> new Money(999)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Money(-1000)).isInstanceOf(IllegalArgumentException.class);
    }
}
