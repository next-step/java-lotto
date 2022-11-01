package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("로또 번호가 1~45 사이의 숫자가 아닌 경우 예외 발생")
    @Test
    void validateTest() {
        assertThatThrownBy(() -> new LottoNumber(0))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
