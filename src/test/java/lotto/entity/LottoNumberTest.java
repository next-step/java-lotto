package lotto.entity;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void 범위_검증() {
        assertThatThrownBy(() -> new LottoNumber(56)).isInstanceOf(IllegalArgumentException.class);
    }
}
