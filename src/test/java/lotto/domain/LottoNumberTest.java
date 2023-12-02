package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("1-45사이가 아닌 숫자를 전달하면 IllegalArgumentException을 던진다.")
    @Test
    void checkTest() {
        assertThatThrownBy(() -> LottoNumber.check(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.check(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
