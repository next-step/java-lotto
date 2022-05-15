package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("로또 넘버 생성자")
    void create() {
        LottoNumber lottoNumber = LottoNumber.of(3);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(3));
    }

    @Test
    @DisplayName("1에서 45 사이의 숫자가 아닐 경우 Exception")
    void exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoNumber.of(46))
                .withMessage("1에서 45사이의 숫자만 입력 가능합니다.");
    }

}