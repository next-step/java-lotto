package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1000})
    void create(int money) {
        // given
        Money self = new Money(money);

        // when
        Money other = new Money(money);

        // then
        assertThat(self).isEqualTo(other);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, -1})
    void invalid_create(int money) {
        // given
        assertThatThrownBy(() -> {
            new Money(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
