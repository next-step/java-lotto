package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.exception.BallException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("생성 테스트")
    void ball_ctor_test() {
        assertThatNoException().isThrownBy(() -> new LottoNumber(1));
    }

    @Test
    @DisplayName("로또 번호가 1이상이 아닐 경우 예외가 발생한다.")
    void ballNumber_not_more1_throw_exception() {
        assertThatThrownBy(() -> new LottoNumber(0))
            .isInstanceOf(BallException.class)
            .hasMessage("로또 번호는 1이상의 값을 가져야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 45이하가 아닐 경우 예외가 발생한다.")
    void ballNumber_not_less45_throw_exception() {
        assertThatThrownBy(() -> new LottoNumber(46))
            .isInstanceOf(BallException.class)
            .hasMessage("로또 번호는 45이하의 값을 가져야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 1이상 45이하 일 경우 예외가 발생하지 않는다.")
    void ballNumber_more1_less45_not_throw_exception() {
        assertThatNoException().isThrownBy(() -> new LottoNumber(1));
        assertThatNoException().isThrownBy(() -> new LottoNumber(45));
    }

}
