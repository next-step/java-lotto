package lotto.domain;

import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NOTHING;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningStatisticsTest {

    @Test
    @DisplayName("로또 당첨 통계를 알려준다.")
    void inform_lotto_winning_statistics() {
        // given
        Lotto winnerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = createGivenLottos();

        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(winnerLotto);

        // when
        List<RankResult> result = lottoWinningStatistics.informStatistics(lottos);

        // then
        assertThat(result).isEqualTo(createExpectedRankResults());
    }

    private Lottos createGivenLottos() {
        return new Lottos(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 3, 5, 7, 9, 11),
                new Lotto(2, 4, 6, 8, 10, 12),
                new Lotto(1, 2, 4, 5, 43, 45),
                new Lotto(13, 14, 15, 16, 17, 18),
                new Lotto(7, 8, 9, 10, 11, 12)
        );
    }

    private List<RankResult> createExpectedRankResults() {
        List<RankResult> expectedRankResults = new ArrayList<>();
        expectedRankResults.add(new RankResult(NOTHING, 2));
        expectedRankResults.add(new RankResult(FOURTH, 2));
        expectedRankResults.add(new RankResult(THIRD, 1));
        expectedRankResults.add(new RankResult(SECOND, 0));
        expectedRankResults.add(new RankResult(FIRST, 1));
        return expectedRankResults;
    }
}
