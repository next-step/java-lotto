package lotto.domain;

import lotto.domain.winning.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 통계 테스트")
public class WinningStatisticsTest {
    WinningStatistics statistics = WinningStatistics.zero();

    @DisplayName("당첨 통계 초기값")
    @Test
    public void initialWinningStatistics() {
        for (int winningCount = 0; winningCount <= 6; winningCount++) {
            int count = statistics.getWinningLottoCount(winningCount);

            assertThat(count).isEqualTo(0);
        }
    }

    @DisplayName("당첨 통계 누적")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:1", "4:1", "5:1", "6:1", "7:0"}, delimiter = ':')
    public void accumulateStatistics(int winningCount, int expectedLottoCount) {
        statistics.increaseWinningLottoCount(winningCount);

        int lottoCount = statistics.getWinningLottoCount(winningCount);

        assertThat(lottoCount).isEqualTo(expectedLottoCount);
    }


    @DisplayName("당첨 통계를 기준으로 당첨 금액 계산")
    @Test
    public void getRevenue() {
        WinningStatistics statistics = WinningStatistics.of(new HashMap<Integer, Integer>() {{
            put(3, 1);
            put(4, 1);
            put(5, 1);
            put(6, 0);
        }});

        int revenue = statistics.calculateRevenue();

        assertThat(revenue).isEqualTo(1555000);
    }
}