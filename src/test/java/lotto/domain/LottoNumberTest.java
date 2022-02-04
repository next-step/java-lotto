package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void 복권의_숫자생성() {
        int number = 5;

        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @Test
    void 복권의_숫자는_1부터_45사이의_숫자여야_한다() {
        int number = 47;

        assertThatThrownBy(() -> new LottoNumber(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("복권의 숫자 범위가 유효하지 않습니다.");
    }
}
