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
        List<Rank> ranks = List.of(rank);
        LottoStatistics stats = new LottoStatistics(ranks);
        assertThat(stats.getCountByRank(rank)).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("총 수익률을 계산한다")
    void 수익률_계산() {
        List<Rank> ranks = List.of(Rank.FIRST);
        LottoStatistics stats = new LottoStatistics(ranks);
        double rate = stats.calculateProfitRate(2_000);
        assertThat(rate).isEqualTo(1_000_000.0);
    }
}
