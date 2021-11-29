package lotto.model;

import lotto.factory.LottoFactory;
import lotto.factory.LottoNumbersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("수동 로또 발행")
    void manualTicket() {
        LottoNumbers lottoNumbers = LottoNumbersFactory.manualCreateSingleNumbers("1, 2, 3, 4, 5, 6");
        Lotto lotto = LottoFactory.manualCreateSingleLotto(lottoNumbers);
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("자동 로또 발행")
    void autoCreateTicket() {
        Lotto lotto = LottoFactory.autoCreateLotto(1);
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    }
}