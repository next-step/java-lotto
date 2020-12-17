package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName(value = "보너스 번호가 45보다 크거나 1보다 작으면 예외")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_번호의_범위_체크(int number) {
        // when
        assertThatThrownBy(() -> {
            BonusNumber.newNumber(number);
            // then
        }).isInstanceOf(IllegalArgumentException.class);
    }
}