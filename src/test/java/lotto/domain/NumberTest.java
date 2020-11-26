package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {
    @ParameterizedTest
    @DisplayName("1~45가 아닌 수 생성하려 할 때")
    @ValueSource(ints = {0, 46})
    void createNumber_not_between_1_45(int number) {
        assertThatThrownBy(() -> {
            new Number(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Number must be between 1 and 45");
    }
}