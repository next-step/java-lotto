package lotto.domain;

import lotto.domain.winning.WinningReward;
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
        for (WinningReward winningReward : WinningReward.values()) {
            int count = statistics.getWinningLottoCount(winningReward);

            assertThat(count).isEqualTo(0);
        }
    }

    @DisplayName("당첨 통계 누적")
    @ParameterizedTest
    @CsvSource(value = {"0:false:0", "1:false:0", "2:false:0", "3:false:1", "4:false:1", "5:false:1", "5:true:1", "6:false:1", "7:false:0"}, delimiter = ':')
    public void accumulateStatistics(int winningCount, boolean matchBonusNumber, int expectedLottoCount) {
        statistics.increaseWinningLottoCount(winningCount, matchBonusNumber);

        int lottoCount = statistics.getWinningLottoCount(WinningReward.findWinningCount(winningCount, matchBonusNumber));

        assertThat(lottoCount).isEqualTo(expectedLottoCount);
    }


    @DisplayName("당첨 통계를 기준으로 당첨 금액 계산")
    @Test
    public void getRevenue() {
        WinningStatistics statistics = WinningStatistics.of(new HashMap<WinningReward, Integer>() {{
            put(WinningReward.THREE, 1);
            put(WinningReward.FOUR, 1);
            put(WinningReward.FIVE, 1);
            put(WinningReward.FIVE_WITH_BONUS, 0);
            put(WinningReward.SIX, 0);
        }});

        int revenue = statistics.calculateRevenue();

        assertThat(revenue).isEqualTo(1555000);
    }
}