package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoRankingSystem;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.as;

class LottoWinningStatisticsTest {
    @DisplayName("사용자 로또 번호와 당첨 번호를 매칭하여 당첨 통계 객체를 생성한다.")
    @Test
    void create() {
        Lotto twoMatchingCount = new Lotto(List.of(1, 2, 9, 10, 11, 12));
        Lotto threeMatchingCount = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto allMatchingCount = new Lotto(1, 2, 3, 4, 5, 6);
        List<Lotto> usersLottoTicket = List.of(twoMatchingCount, threeMatchingCount, allMatchingCount);
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);

        LottoWinningStatistics winningStatistics = new LottoWinningStatistics(usersLottoTicket, winningLotto);

        assertThat(winningStatistics)
                .extracting("values", as(InstanceOfAssertFactories.MAP))
                .extractingByKeys(LottoRankingSystem.FIFTH, LottoRankingSystem.FIRST)
                .containsExactly(1, 1);
    }

    @DisplayName("당첨된 로또의 금액을 계산한다.")
    @Test
    void calculate_winning_amount() {
        Map<LottoRankingSystem, Integer> statistics = new HashMap<>();
        statistics.put(LottoRankingSystem.FIRST, 1);
        statistics.put(LottoRankingSystem.FIFTH, 1);
        LottoWinningStatistics winningStatistics = new LottoWinningStatistics(statistics);

        int result = winningStatistics.calculateWinningAmount();

        assertThat(result).isEqualTo(2000000000 + 5000);
    }

    @DisplayName("인자로 전달받은 등수에 해당하는 로또의 갯수를 반환한다.")
    @Test
    void return_lotto_quantity_by_ranking() {
        Map<LottoRankingSystem, Integer> statistics = new HashMap<>();
        statistics.put(LottoRankingSystem.FIRST, 2);
        LottoWinningStatistics winningStatistics = new LottoWinningStatistics(statistics);

        int result = winningStatistics.getLottoQuantityOfRanking(LottoRankingSystem.FIRST);

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("로또 당첨금액과 로또 구입금액을 전달받아서 수익률을 계산하여 반환한다.")
    @Test
    void calculate_returnRate() {
        float actual = LottoWinningStatistics.calculateReturnRate(1_500_000, 5000);

        assertThat(actual).isEqualTo(300.0f);
    }
}
