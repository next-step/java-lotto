package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumberTest {

    @Test
    @DisplayName("정상입력")
    void positiveNumber() {
        // given
        PositiveNumber positiveNumber = new PositiveNumber("3");

        // when then
        assertThat(3).isEqualTo(positiveNumber.getPositiveNumber());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "-", "   "})
    @DisplayName("숫자가 아닌 값 입력 시 예외발생")
    void positiveNumber_nonNumber(String param) {
        assertThatThrownBy(() -> new PositiveNumber(param))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수 입력 시 예외발생")
    void positiveNumber_negativeNumber() {
        assertThatThrownBy(() -> new PositiveNumber("-1"))
                .isInstanceOf(RuntimeException.class);
    }

}