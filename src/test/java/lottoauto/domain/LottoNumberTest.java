package lottoauto.domain;

import lottoauto.model.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    void generateLottoNumberTest() {
        int number = 3;
        LottoNumber lottoNumber = LottoNumber.from(number);

        Assertions.assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @Test
    void generateLottoNumberFailTest() {
        int number = 99;
        Assertions.assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자는 1에서 45사이의 숫자여야 합니다.");
    }


}
