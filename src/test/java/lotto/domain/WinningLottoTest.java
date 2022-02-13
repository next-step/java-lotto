package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 당첨로또_생성() {
        // given
        LottoNumbers lottoNumbers = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(3);

        // when & then
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
