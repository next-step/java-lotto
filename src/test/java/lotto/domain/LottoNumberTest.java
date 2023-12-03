package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("1-45사이의 숫자를 전달하면 해당 LottoNumber 객체를 반환한다.")
    @Test
    void lottoNumberTest() {
        assertThat(LottoNumber.from(1)).isInstanceOf(LottoNumber.class);
        assertThat(LottoNumber.from(45)).isInstanceOf(LottoNumber.class);
    }

    @DisplayName("1-45사이가 아닌 숫자를 전달하면 IllegalArgumentException을 던진다.")
    @Test
    void lottoNumberExceptionTest() {
        assertThatThrownBy(() -> LottoNumber.from(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.from(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
