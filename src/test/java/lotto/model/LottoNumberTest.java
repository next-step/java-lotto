package lotto.model;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("LottoNumber는_1부터_45사이다")
    @Test
    void lottoNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
            () -> new LottoNumber(46));
    }
}
