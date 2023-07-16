package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoRatioTest {

    @ParameterizedTest
    @ValueSource(doubles = {0, 0.13, 0.72})
    @DisplayName("수익률을 정상적으로 생성한다.")
    void create(final double value) {
        /* given */

        /* when & then */
        assertDoesNotThrow(() -> new LottoRatio(value));
    }

    @Test
    @DisplayName("수익률이 0보다 작을 경우 IllgealArgumentException을 던진다.")
    void createFailWithLessThanZero() {
        /* given */
        final double value = -0.13;

        /* when & then */
        assertThatThrownBy(() -> new LottoRatio(value)).isInstanceOf(IllegalArgumentException.class);
    }
}
