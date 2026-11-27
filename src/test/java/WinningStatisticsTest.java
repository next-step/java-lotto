import domain.Lotto;
import domain.Lottos;
import domain.Rank;
import domain.WinningLotto;
import domain.WinningStatistics;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {


    @ParameterizedTest
    @CsvSource({"FIFTH, 2", "FIRST, 1", "FOURTH, 0"})
    void 등수_목록을_등수별로_집계한다(Rank rank, int expectedCount) {
        WinningStatistics statistics = new WinningStatistics(Rank.FIFTH, Rank.FIFTH, Rank.MISS, Rank.FIRST, Rank.MISS);
        assertThat(statistics.countOf(rank)).isEqualTo(expectedCount);
    }


    @Test
    void 총_상금은_등수별_상금과_개수의_곱의_합이다() {
        WinningStatistics statistics = new WinningStatistics(Rank.FIFTH, Rank.FIFTH, Rank.FOURTH, Rank.MISS);
        assertThat(statistics.totalPrize()).isEqualTo(5_000L * 2 + 50_000L);
    }


    @Test
    void 총_수익률은_총_상금_나누기_구입_금액이다() {
        WinningLotto winningLotto = new WinningLotto(7, 1, 2, 3, 4, 5, 6);
        Lottos lottos = new Lottos(new Lotto(1, 2, 3, 10, 11, 12));

        WinningStatistics statistics = new WinningStatistics(lottos.checkResult(winningLotto));

        assertThat(statistics.profitRate(14000)).isEqualTo(5_000.0 / 14000);
    }
}