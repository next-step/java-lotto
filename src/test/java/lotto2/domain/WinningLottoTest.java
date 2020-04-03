package lotto2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto2.domain.Fixture.oneLotto;
import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @DisplayName("당첨 로또의 등수를 구할 수 있다.")
   @Test
    void testLottoNumberMatch() {
        WinningLotto winningLotto = new WinningLotto(oneLotto());
        assertThat(Prize.FIRST).isSameAs(winningLotto.match(oneLotto()));
    }
}
