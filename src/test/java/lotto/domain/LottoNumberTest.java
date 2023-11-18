package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumberTest {

    @Test
    @DisplayName("랜덤한 로또 번호를 입력받아 생성할 수 있다.")
    void createLottoNumberTest() {
        // given
        int randomNumber = 1;

        // when
        LottoNumber lottoNumber = new LottoNumber(randomNumber);

        // then
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }
}
