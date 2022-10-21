package lotto.domain.money;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ImmutableMoneyTest {

    @Test
    void create() {
        ImmutableMoney actual = new ImmutableMoney(1000);
        assertAll(
                () -> assertThat(actual).isEqualTo(new ImmutableMoney(1000)),
                () -> assertThat(actual).isEqualTo(new Money(1000))
        );
    }

    @Test
    void valid() {
        assertThatThrownBy(() -> new Money(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
