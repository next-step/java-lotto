package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 숫자가 1-45사이가 아니면 에러를 던진다")
    void 로또숫자_validation() {
        assertThatThrownBy(() -> LottoNumber.valueOf(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 숫자 equals 확인")
    void 로또숫자_equals() {
        LottoNumber lottoNumber1 = LottoNumber.valueOf(1);
        LottoNumber lottoNumber2 = LottoNumber.valueOf(1);

        assertThat(lottoNumber1).isEqualTo(lottoNumber2);

    }
}
