package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.fixture.LottoFixture.createLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class WinningResultTest {


    @Test
    @DisplayName("당첨 결과 테스트")
    void 당첨_결과() {
        // given
        WinningLotto winningLotto = new WinningLotto(
                List.of(1, 2, 3, 4, 5, 6), 7
        );
        PurChasedLottos purChasedLottos = new PurChasedLottos(
                List.of(
                        createLotto(1, 2, 3, 4, 5, 6),
                        createLotto(1, 3, 11, 12, 5, 6),
                        createLotto(1, 2, 3, 4, 5, 6)),
                new LottoMoney(14000)
        );

        // when
        WinningResult winningResult = WinningResult.of(
                winningLotto,
                purChasedLottos);

        // then
        assertThat(winningResult.getCountOfRank(Rank.SIX)).isEqualTo(2);
        assertThat(winningResult.getCountOfRank(Rank.FIVE_WITH_BONUS)).isEqualTo(0);
        assertThat(winningResult.getCountOfRank(Rank.FIVE)).isEqualTo(0);
        assertThat(winningResult.getCountOfRank(Rank.FOUR)).isEqualTo(1);
        assertThat(winningResult.getCountOfRank(Rank.THREE)).isEqualTo(0);
    }

    @Test
    @DisplayName("수익률 테스트")
    void 수익률() {
        // given
        WinningLotto winningLotto = new WinningLotto(
                List.of(1, 2, 3, 4, 5, 6), 7
        );
        PurChasedLottos purChasedLottos = new PurChasedLottos(
                List.of(
                        createLotto(11, 22, 33, 44, 15, 16),
                        createLotto(1, 3, 11, 12, 5, 7),
                        createLotto(12, 23, 31, 42, 15, 16)),
                new LottoMoney(14000)
        );

        // when
        WinningResult winningResult = WinningResult.of(winningLotto, purChasedLottos);

        // then
        assertThat(winningResult.getProfit()).isCloseTo(0.35, within(100.0));
    }
}
