package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MoneyTest {
    @ParameterizedTest
    @ValueSource(strings = {"900", "200"})
    @DisplayName("입력한 금액이 1000원 미만이면 exception")
    void money_100원미만(String input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}