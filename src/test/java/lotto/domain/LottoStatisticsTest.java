package lotto.domain;

import lotto.domain.winning.WinningCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoStatisticsTest {
    @Test
    @DisplayName("통계 표현")
    void createLottoStatistics() {
        List<WinningCount> autoResult = Arrays.asList(WinningCount.THREE, WinningCount.FOUR
                , WinningCount.FIVE, WinningCount.FIVE, WinningCount.SIX,WinningCount.THREE, WinningCount.FOUR
                , WinningCount.FIVE, WinningCount.FIVE, WinningCount.SIX);

        Map<WinningCount, Integer> expected = new HashMap<>();
        expected.put(WinningCount.THREE, 2);
        expected.put(WinningCount.FOUR, 2);
        expected.put(WinningCount.FIVE, 4);
        expected.put(WinningCount.FIVE_WITH_BONUS_BALL, 0);
        expected.put(WinningCount.SIX, 2);

        LottoStatistics statistics = new LottoStatistics(10_000, autoResult);

        assertThat(statistics.getStatistics()).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률")
    void rate() {
        List<WinningCount> result = Arrays.asList(WinningCount.THREE);

        LottoStatistics statistics = new LottoStatistics(14000, result);

        assertThat(statistics.getRate()).isEqualTo("0.35");
    }
}
