package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCheckerTest {

    @Test
    @DisplayName("다수의 로또 당첨 결과 확인")
    void checkLottos() {
        Lotto lotto1 = new Lotto(size -> Numbers.builder().range(1, 7).build());
        Lotto lotto2 = new Lotto(size -> Numbers.builder().range(2, 8).build());
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2));
        WinningLotto winningLotto = new WinningLotto(Numbers.builder().range(1, 7).build());

        WinningChecker winningChecker = new WinningChecker(winningLotto);
        WinningRanks winningRanks = winningChecker.checkRanks(lottos);

        WinningRanks expectedWinningRanks = new WinningRanks(Arrays.asList(WinningRank.FIRST, WinningRank.SECOND));
        assertThat(winningRanks).isEqualTo(expectedWinningRanks);
    }
}
