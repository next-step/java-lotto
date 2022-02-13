package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void 복권의_숫자생성() {
        int number = 5;

        LottoNumber lottoNumber = LottoNumber.from(number);

        assertThat(lottoNumber.getValue()).isEqualTo(number);
    }

    @Test
    void 복권의_숫자는_1부터_45사이의_숫자여야_한다() {
        int number = 47;

        assertThatThrownBy(() -> LottoNumber.from(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("복권의 숫자 범위가 유효하지 않습니다.");
    }
}
