package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    void 보너스번호일치() {
        LottoNumber lottoNumber = new LottoNumber(6);
        LottoNumber bonusNumber = new LottoNumber(6);

        assertThat(lottoNumber.isSameNumber(bonusNumber)).isTrue();
    }
}
