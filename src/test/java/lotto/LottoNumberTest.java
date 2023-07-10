package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호는 번호가 1 ~ 45의 범위를 가질 때 정상적으로 생성된다.")
    void create() {
        Assertions.assertThatNoException().isThrownBy(() -> new LottoNumber(1));
        Assertions.assertThatNoException().isThrownBy(() -> new LottoNumber(45));
    }

    @Test
    @DisplayName("로또 번호는 정상 범위 이외일 때 예외를 던진다.")
    void validLottoNumber() {
        Assertions.assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
