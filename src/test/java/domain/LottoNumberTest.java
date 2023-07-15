package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호를 정상적으로 생성한다.")
    void createSuccess() {
        /* given */
        final int value = 7;

        /* when & then */
        assertDoesNotThrow(() -> new LottoNumber(value));
    }

    @ValueSource(ints = {-5, 0, 46})
    @ParameterizedTest
    @DisplayName("로또 번호의 값이 정상 범위 밖에 있는 경우 IllegalArgumentException을 던진다.")
    void createFailWithIllegalArgumentException(final int value) {
        /* given */

        /* when & then */
        assertThatThrownBy(() -> new LottoNumber(value)).isInstanceOf(
            IllegalArgumentException.class);
    }
}
