package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

    @Test
    @DisplayName("숫자 정상 생성 입력 테스트")
    void ball_inputValidateNumber() {
        /* given & when & then */
        assertDoesNotThrow(() -> new Ball("10"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"46", "0", "-1"})
    @DisplayName("숫자 범위 초과 입력 테스트")
    void ball_outOfRangeNumber(final String value) {
        /* given & when & then */
        assertThatThrownBy(() -> new Ball(value)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "1,2", "", " "})
    @DisplayName("숫자가 아닌 문자열 입력 테스트")
    void ball_notNumericInput(final String value) {
        /* given & when & then */
        assertThatThrownBy(() -> new Ball(value)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
