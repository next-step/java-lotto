package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void valid() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

}