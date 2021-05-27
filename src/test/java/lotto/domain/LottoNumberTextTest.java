package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTextTest {

    @ParameterizedTest
    @ValueSource(strings = {"   ", "1,2,3,", "1,2,3,4,5,6,7"})
    void invalid(String numberText) {
        assertThatThrownBy(() -> new LottoNumberText(numberText)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void text() {
        // given
        String numberText = "1,2,3,4,5,6";
        LottoNumberText lottoNumberText = new LottoNumberText(numberText);

        // then
        assertThat(lottoNumberText.text()).isEqualTo(numberText);
    }
}
