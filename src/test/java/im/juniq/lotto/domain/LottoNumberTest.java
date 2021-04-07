package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void create() {
        assertThatCode(() -> LottoNumber.from(1)).doesNotThrowAnyException();
        assertThatCode(() -> LottoNumber.from(45)).doesNotThrowAnyException();
    }

    @Test
    void checkNumber() {
        assertThatThrownBy(() -> LottoNumber.from(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.from(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
