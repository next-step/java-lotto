package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(new LottoAutoGenerator().getLottoNumbers());
    }

    @DisplayName("당첨 로또의 등수를 구할 수 있다.")
    @Test
    void testLottoNumberMatch() {

        WinningLotto winningLotto = new WinningLotto(lotto);
        assertThat(Prize.FIRST).isSameAs(winningLotto.match(lotto));
    }
}
