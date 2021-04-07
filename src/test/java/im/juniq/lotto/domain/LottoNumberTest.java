package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void create() {
        assertThatCode(() -> LottoNumber.of(1)).doesNotThrowAnyException();
        assertThatCode(() -> LottoNumber.of(45)).doesNotThrowAnyException();
    }

    @Test
    void checkNumber() {
        assertThatThrownBy(() -> LottoNumber.of(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.of(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
