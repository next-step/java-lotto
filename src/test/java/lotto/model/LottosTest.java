package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    @DisplayName("2등 당첨을 포함하지 않는 로또 당첨 결과를 계산한다.")
    void getLottosResult() {
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(1, 2, 3, 4, 5, 6),
                        new Lotto(2, 3, 4, 5, 6, 7),
                        new Lotto(3, 4, 5, 6, 7, 8)
                )
        );
        WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), 45);
        assertThat(lottos.match(winningLotto))
                .isEqualTo(new LottoResults(Map.of(Prize.FOURTH, 1, Prize.THIRD, 1, Prize.FIRST, 1)));
    }

    @Test
    @DisplayName("2등 당첨을 포함한 로또 당첨 결과를 계산한다.")
    void getLottosResultWithSecondPrize() {
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(1, 2, 3, 4, 5, 6),
                        new Lotto(2, 3, 4, 5, 6, 45),
                        new Lotto(3, 4, 5, 6, 7, 8)
                )
        );
        WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), 45);
        assertThat(lottos.match(winningLotto))
                .isEqualTo(new LottoResults(Map.of(Prize.FOURTH, 1, Prize.SECOND, 1, Prize.FIRST, 1)));
    }
}