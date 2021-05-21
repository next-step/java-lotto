package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoesTest {

    @DisplayName("로또를 구입하면 로또 개수가 1개 증가한다")
    @Test
    void buy_lotto() {
        // given
        Lottoes lottoes = Lottoes.init();

        // when
        lottoes.buyLotto(new TestLottoNumberGenerator());

        // then
        assertThat(lottoes.getLottoCount()).isEqualTo(1);
    }
}
