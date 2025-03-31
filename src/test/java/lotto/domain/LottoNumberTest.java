package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("1부터 45까지의 숫자만 생성할 수 있다.")
    void testLottoNumberCreation() {
        Assertions.assertThatThrownBy(() -> LottoNumber.valueOf(0))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> LottoNumber.valueOf(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 23은 생성될 수 있다.")
    void testLottoNumberCreation_1() {
        LottoNumber lottoNumber = LottoNumber.valueOf(23);
        Assertions.assertThat(lottoNumber).isEqualTo(LottoNumber.TWENTY_THREE);
    }

}
