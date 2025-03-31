package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.vo.LottoStatisticsValue;
import lotto.service.LottoCheckerService;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCheckerServiceTest {
    @Test
    @DisplayName("당첨 여부 테스트 (로또 구매가 없는 경우)")
    void checkLottosTestByEmpty() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoStatistics stats = new LottoCheckerService(winningLotto).check(List.of());

        assertThat(stats.getLottoStatisticsDTOs()).containsExactly(
            new LottoStatisticsValue(PrizeLevel.FIRST, 0),
            new LottoStatisticsValue(PrizeLevel.SECOND, 0),
            new LottoStatisticsValue(PrizeLevel.THIRD, 0),
            new LottoStatisticsValue(PrizeLevel.FOURTH, 0),
            new LottoStatisticsValue(PrizeLevel.FIFTH, 0)
        );
    }

    @Test
    @DisplayName("당첨 여부 테스트 (로또 구매가 있는 경우)")
    void checkLottosTest() {
        List<Lotto> lottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 5, 8)),
            new Lotto(List.of(1, 2, 3, 4, 8, 9)),
            new Lotto(List.of(1, 2, 3, 10, 11, 12))
        );

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoStatistics stats = new LottoCheckerService(winningLotto).check(lottos);

        assertThat(stats.getLottoStatisticsDTOs()).containsExactly(
            new LottoStatisticsValue(PrizeLevel.FIRST, 1),
            new LottoStatisticsValue(PrizeLevel.SECOND, 1),
            new LottoStatisticsValue(PrizeLevel.THIRD, 1),
            new LottoStatisticsValue(PrizeLevel.FOURTH, 1),
            new LottoStatisticsValue(PrizeLevel.FIFTH, 1)
        );
    }
}
