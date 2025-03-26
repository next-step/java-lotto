package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @ParameterizedTest
    @DisplayName("로또들의 당첨 통계를 계산한다")
    @CsvSource({"FIRST, 1", "SECOND, 1", "THIRD, 1", "FOURTH, 1"})
    void 당첨_통계_계산(Rank rank, int expectedCount) {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        Lotto first = new Lotto(List.of(1,2,3,4,5,6));
        Lotto second = new Lotto(List.of(1,2,3,4,5,10));
        Lotto third = new Lotto(List.of(1,2,3,4,10,11));
        Lotto fourth = new Lotto(List.of(1,2,3,10,11,12));

        List<Lotto> lottos = List.of(first, second, third, fourth);
        List<Rank> ranks = lottos.stream()
                .map(lotto -> RankDecider.decide(lotto, winningNumber))
                .collect(Collectors.toList());
        LottoStatistics stats = new LottoStatistics(ranks);

        assertThat(stats.getCountByRank(rank)).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("총 수익률을 계산한다")
    void 수익률_계산() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        Lotto first = new Lotto(List.of(1,2,3,4,5,6));
        Lotto none = new Lotto(List.of(10,11,12,13,14,15));

        List<Lotto> lottos = List.of(first, none);
        List<Rank> ranks = lottos.stream()
                .map(lotto -> RankDecider.decide(lotto, winningNumber))
                .collect(Collectors.toList());
        LottoStatistics stats = new LottoStatistics(ranks);

        double rate = stats.calculateProfitRate(2_000);

        assertThat(rate).isEqualTo(1_000_000.0);
    }
}
