package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Test
    @DisplayName("로또 넘버 객체가 가지고있는 번호를 int타입으로 반환한다")
    void toInt() {
        LottoNumber lottoNumber = LottoNumber.from(1);
        Assertions.assertThat(lottoNumber.toInt()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 번호가 1~45가 아닌 경우 예외를 던진다")
    void exception() {
        Assertions.assertThatThrownBy(() -> LottoNumber.from(46))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("lotto number must be greater than 1 and less than 45");
    }
}
