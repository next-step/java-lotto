package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void create() {
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}