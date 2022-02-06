package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidatorTest {

    private static final int MINIMUM_BALL_NUMBER = 1;
    private static final int MAXIMUM_BALL_NUMBER = 45;

    @Test
    void 유효한_범위_내의_숫자일_경우() {
        for (int i = 1; i <= 45; i++) {
            assertThat(i).isEqualTo(NumberValidator.validateRange(i));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 123, 123123, 3432})
    void 범위에_속하지_않는_숫자일_경우(int invalidateNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> NumberValidator.validateRange(invalidateNumber)).withMessage(
                "[ERROR] " + MINIMUM_BALL_NUMBER + "부터 " + MAXIMUM_BALL_NUMBER + "까지의 숫자만 입력해주세요.");
    }
}