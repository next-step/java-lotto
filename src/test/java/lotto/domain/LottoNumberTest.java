package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("로또 생성 테스트")
    @Test
    void lottoNumber_generate_test() {
        LottoNumber lottoNumber = new LottoNumber(10);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(10));
    }

    @DisplayName("로또 값 유효성 체크")
    @Test
    void lottoNumber_valid_test() {
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
