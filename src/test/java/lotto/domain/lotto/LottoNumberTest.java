package lotto.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("로또번호를 생성한다. 로또 번호가 1~45 의 숫자가 아닌 경우 예외가 발생한다")
    public void create() {
        Assertions.assertThatThrownBy(() -> LottoNumber.of(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또번호를 생성한다. 이전에 있던 번호인 경우에는 같은 객체를 반환한다")
    public void create_cash() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        Assertions.assertThat(lottoNumber == LottoNumber.of(1)).isTrue();
        Assertions.assertThat(lottoNumber == LottoNumber.of(2)).isFalse();
    }
}
