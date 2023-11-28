package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningStatisticsTest {

    @Test
    @DisplayName("로또 당첨 통계를 알려준다.")
    void inform_lotto_winning_statistics() {
        // given
        Lotto winnerLotto = new Lotto(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(new WinnerLotto(winnerLotto,
                LottoNumber.valueOf(bonusNumber)));

        // when
        RankResult result = lottoWinningStatistics.informStatistics(createGivenLottos());

        // then
        assertThat(result).isEqualTo(createExpectedRankResult());
    }

    private Lottos createGivenLottos() {
        return new Lottos(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 3, 5, 7, 9, 11),
                new Lotto(2, 4, 6, 8, 10, 12),
                new Lotto(1, 2, 4, 5, 3, 7),
                new Lotto(13, 14, 15, 16, 17, 18),
                new Lotto(7, 8, 9, 10, 11, 12)
        );
    }

    private RankResult createExpectedRankResult() {
        Map<Rank, Long> expectedRankResult = new HashMap<>();
        expectedRankResult.put(FIFTH, 2L);
        expectedRankResult.put(FOURTH, 0L);
        expectedRankResult.put(THIRD, 0L);
        expectedRankResult.put(SECOND, 1L);
        expectedRankResult.put(FIRST, 1L);
        return new RankResult(expectedRankResult);
    }
}
