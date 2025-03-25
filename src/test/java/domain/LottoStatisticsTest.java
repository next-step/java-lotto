package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @Test
    @DisplayName("로또들의 당첨 통계를 계산한다")
    void 당첨_통계_계산() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        Lotto first = new Lotto(List.of(1,2,3,4,5,6));
        Lotto second = new Lotto(List.of(1,2,3,4,5,10));
        Lotto third = new Lotto(List.of(1,2,3,4,10,11));
        Lotto fourth = new Lotto(List.of(1,2,3,10,11,12));

        List<Lotto> lottos = List.of(first, second, third, fourth);
        LottoStatistics stats = new LottoStatistics(lottos, winningNumber);

        assertThat(stats.getCountByRank(Rank.FIRST)).isEqualTo(1);
        assertThat(stats.getCountByRank(Rank.SECOND)).isEqualTo(1);
        assertThat(stats.getCountByRank(Rank.THIRD)).isEqualTo(1);
        assertThat(stats.getCountByRank(Rank.FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 수익률을 계산한다")
    void 수익률_계산() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        Lotto first = new Lotto(List.of(1,2,3,4,5,6));
        Lotto none = new Lotto(List.of(10,11,12,13,14,15));

        List<Lotto> lottos = List.of(first, none);
        LottoStatistics stats = new LottoStatistics(lottos, winningNumber);

        double rate = stats.calculateProfitRate(2_000);

        assertThat(rate).isEqualTo(1_000_000.0);
    }
}
