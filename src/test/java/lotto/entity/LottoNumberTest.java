package lotto.entity;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void 당첨_숫자_범위_넘어가는_예외() {
        assertThatThrownBy(() -> new LottoNumber(65)).isInstanceOf(IllegalArgumentException.class);
    }
}
