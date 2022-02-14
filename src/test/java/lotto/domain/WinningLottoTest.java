package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    Lottos lottos = new Lottos();
    LottoResult lottoResult = new LottoResult("1, 2, 3, 4, 5, 6", "7");

    @BeforeEach
    void setUp() {
        lottos.makeManualLottos(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinningLotto.getMatchWin(lottos, lottoResult);
    }

    @Test
    void 일등_우승상금_테스트() {
        assertThat(WinningLotto.getWinProfit()).isEqualTo(2000000000);
    }
}
