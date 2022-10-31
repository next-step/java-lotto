package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("로또 번호 생성 시 1미만의 번호가 입력되면 예외 처리")
    @Test
    void lotto_number_greater_than_0() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> LottoNumber.from(0));
    }

    @DisplayName("로또 번호 생성 시 45 초과 번호가 입력되면 예외 처리")
    @Test
    void lotto_number_less_than_46(){
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> LottoNumber.from(46));
    }
}
