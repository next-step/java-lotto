package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("로또 번호를 생성한다")
    @Test
    void createLottoNumberTest() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber.value()).isEqualTo(1);
    }

    @DisplayName("로또 번호는 1 미만, 45 초과일 때 예외를 발생시킨다")
    @Test
    void createLottoNumberExceptionTest() {
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
