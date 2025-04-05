package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.MatchCount;
import lotto.domain.RandomLottoNumberGenerator;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 구입 개수만큼 Lotto를 갖는다.")
    @Test
    void purchase() {
        Lottos lottos = new Lottos(15, new RandomLottoNumberGenerator());
        assertThat(lottos.count()).isEqualTo(15);
    }

    @DisplayName("로또들 중 당첨 로또의 개수를 집계한다.")
    @Nested
    class count {

        @DisplayName("당첨 번호와 로또 번호의 일치 개수에 따라 로또 개수를 집계한다.")
        @Test
        void countLotto() {
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lottos purchasedLottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8)),
                new Lotto(List.of(4, 5, 6, 7, 8, 9)),
                new Lotto(List.of(5, 6, 7, 8, 9, 10)),
                new Lotto(List.of(6, 7, 8, 9, 10, 11))
            ));

            WinningResult result = purchasedLottos.countMatchResults(winningLotto);

            assertThat(result.countByMatch(MatchCount.THREE)).isEqualTo(1);
            assertThat(result.countByMatch(MatchCount.FOUR)).isEqualTo(1);
            assertThat(result.countByMatch(MatchCount.FIVE)).isEqualTo(1);
            assertThat(result.countByMatch(MatchCount.SIX)).isEqualTo(1);
        }

        @DisplayName("당첨 번호와 로또 번호가 2개 이하로 일치한다면 당첨 로또로 집계하지 않는다.")
        @Test
        void notCountLotto() {
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            Lotto winningLotto = new Lotto(winningNumbers);
            Lottos purchasedLottos = new Lottos(List.of(
                new Lotto(List.of(5, 6, 7, 8, 9, 10)),
                new Lotto(List.of(6, 7, 8, 9, 10, 11))
            ));

            WinningResult result = purchasedLottos.countMatchResults(winningLotto);

            for (MatchCount matchCount : MatchCount.values()) {
                assertThat(result.countByMatch(matchCount)).isZero();
            }
        }
    }
}
