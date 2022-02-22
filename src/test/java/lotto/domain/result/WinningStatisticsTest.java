package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @Test
    void 수익률_계산() {
        Map<LottoResult, Integer> numberOfLottoResults = new HashMap<>();
        numberOfLottoResults.put(LottoResult.THREE_MATCHING, 1);
        WinningStatistics winningStatistics = new WinningStatistics(numberOfLottoResults, 14000);
        assertThat(winningStatistics.getProfitRate()).isEqualTo(0.35);
    }
}
