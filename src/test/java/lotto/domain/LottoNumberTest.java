package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void 복권의_숫자생성() {
        LottoNumber lottoNumber = new LottoNumber(5);

        assertThat(lottoNumber.getNumber()).isEqualTo(5);
    }

    @Test
    void 복권의_숫자는_1부터_45사이의_숫자여야_한다() {
        assertThatThrownBy(() -> new LottoNumber(47))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("복권의 숫자 범위가 유효하지 않습니다.");
    }
}
