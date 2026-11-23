import domain.WinningStatistics;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {


    @ParameterizedTest
    @CsvSource({"3, 2", "6, 1", "4, 0"})
    void 일치_개수_목록을_등수별로_집계한다(int match, int expectedCount) {
        WinningStatistics statistics = new WinningStatistics(List.of(3, 3, 0, 6, 1));

        assertThat(statistics.countOf(match)).isEqualTo(expectedCount);
    }


    @ParameterizedTest
    @CsvSource({"3, 5000", "4, 50000", "5, 1500000", "6, 2000000000"})
    void 일치_개수별_상금을_반환한다(int match, int prize) {
        WinningStatistics statistics = new WinningStatistics(List.of());

        assertThat(statistics.prizeOf(match)).isEqualTo(prize);
    }


    @Test
    void 총_수익률은_총_상금_나누기_구입_금액이다() {
        WinningStatistics statistics = new WinningStatistics(List.of(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        assertThat(statistics.profitRate(14000)).isEqualTo(5_000.0 / 14000);
    }
}