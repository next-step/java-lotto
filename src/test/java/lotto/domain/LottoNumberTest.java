package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    @DisplayName("로또 숫자의 범위가 1~45가 아니면 IllegalArgumentException 이 발생한다.")
    void wrongNumber(int wrongNumber) {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumber(wrongNumber));
    }
}
