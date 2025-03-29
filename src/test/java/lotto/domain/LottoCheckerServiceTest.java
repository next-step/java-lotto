package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.dto.LottoStatisticsDTO;
import lotto.service.LottoCheckerService;
import lotto.service.LottoStatisticsService;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCheckerServiceTest {
    @Test
    @DisplayName("당첨 여부 테스트 (로또 구매가 없는 경우)")
    void checkLottosTestByEmpty() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        LottoStatisticsService stats = new LottoCheckerService(winningLotto).check(List.of());

        assertThat(stats.getLottoStatisticsDTOs()).containsExactly(
            new LottoStatisticsDTO(PrizeLevel.FIRST, 0),
            new LottoStatisticsDTO(PrizeLevel.SECOND, 0),
            new LottoStatisticsDTO(PrizeLevel.THIRD, 0),
            new LottoStatisticsDTO(PrizeLevel.FOURTH, 0)
        );
    }

    @Test
    @DisplayName("당첨 여부 테스트 (로또 구매가 있는 경우)")
    void checkLottosTest() {
        List<Lotto> lottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 7, 8)),
            new Lotto(List.of(1, 2, 3, 7, 8, 9)),
            new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        LottoStatisticsService stats = new LottoCheckerService(winningLotto).check(lottos);

        assertThat(stats.getLottoStatisticsDTOs()).containsExactly(
            new LottoStatisticsDTO(PrizeLevel.FIRST, 1),
            new LottoStatisticsDTO(PrizeLevel.SECOND, 1),
            new LottoStatisticsDTO(PrizeLevel.THIRD, 1),
            new LottoStatisticsDTO(PrizeLevel.FOURTH, 1)
        );
    }
}
