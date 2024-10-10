package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;

class LottoTest {

    @Test
    void 로또_번호를_생성한다() {
        Lotto lotto = new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto pickLottoNumber = lotto.pickLottoNumber();

        assertThat(pickLottoNumber).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
    }
}
