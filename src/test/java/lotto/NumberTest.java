package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName(value = "보너스 번호가 45보다 크거나 1보다 작으면 예외")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또_번호_범위_체크(int number) {
        // when
        assertThatThrownBy(() -> {
            Number.newNumber(number);
            // then
        }).isInstanceOf(IllegalArgumentException.class);
    }
}