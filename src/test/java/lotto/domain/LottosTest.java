package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("당첨된 로또 갯수 확인")
    void matches() {
        Lotto lotto1 = new Lotto(new LottoNumbers(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(new LottoNumbers(1,2,3,4,5,7));
        Lotto lotto3 = new Lotto(new LottoNumbers(1,2,3,4,6,7));
        Lotto winningLotto = new Lotto(new LottoNumbers(1,2,3,4,5,6));

        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3));

        WinningResult winningResult = lottos.matches(winningLotto);

        assertThat(winningResult.getResults())
                .containsExactly(WinningType.FIRST, WinningType.SECOND, WinningType.SECOND);
        assertThat(winningResult.count(WinningType.SECOND)).isEqualTo(2);
    }
}
