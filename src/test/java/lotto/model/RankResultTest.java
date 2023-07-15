package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.fixture.LottoFixture.createLotto;
import static org.assertj.core.api.Assertions.assertThat;

class RankResultTest {

    @Test
    @DisplayName("Rank 에 대해 결과 테스트")
    void Rank_에_대해_결과_테스트() {
        // given
        WinningLotto winningLotto = new WinningLotto(
                List.of(1, 2, 3, 4, 5, 6), 7
        );
        PurChasedLottos purChasedLottos = new PurChasedLottos(
                List.of(
                        createLotto(1, 2, 3, 41, 15, 16),
                        createLotto(4, 5, 6, 12, 15, 16),
                        createLotto(1, 2, 3, 4, 5, 6)),
                new LottoMoney(14000)
        );

        RankResult rankResult = new RankResult(winningLotto, purChasedLottos);

        // when , then
        assertThat(rankResult.getCountOfRank(Rank.THREE))
                .isEqualTo(2);
        assertThat(rankResult.getCountOfRank(Rank.SIX))
                .isEqualTo(1);
        assertThat(rankResult.getCountOfRank(Rank.FIVE))
                .isEqualTo(0);
        assertThat(rankResult.getCountOfRank(Rank.FOUR))
                .isEqualTo(0);
        assertThat(rankResult.getCountOfRank(Rank.FIVE_WITH_BONUS))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("Rank 에 대해 총 상금 테스트")
    void 총_상금_테스트() {
        // given
        WinningLotto winningLotto = new WinningLotto(
                List.of(1, 2, 3, 4, 5, 6), 7
        );
        PurChasedLottos purChasedLottos = new PurChasedLottos(
                List.of(
                        createLotto(1, 2, 3, 41, 15, 16),
                        createLotto(4, 5, 6, 12, 15, 16),
                        createLotto(1, 2, 3, 4, 5, 6)),
                new LottoMoney(14000)
        );
        RankResult rankResult = new RankResult(winningLotto, purChasedLottos);

        // when , then
        assertThat(rankResult.getTotalRankReward())
                .isEqualTo(2_000_010_000);

    }
}