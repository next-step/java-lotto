package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class StatisticsTest {

    @DisplayName(value = "당첨 갯수별 통계 갯수가 맞는지 테스트")
    @Test
    void 통계_갯수() {
        // given
        List<Integer> winningCounts = Arrays.asList(3, 4, 5, 6, 3, 4, 5, 6, 3, 3, 3, 3);
        int[] temp = {6, 2, 2, 2};
        Statistics expectStatistics = new Statistics(temp);
        
        // when
        Statistics statistics = null;
        Statistics initStatistics = new Statistics(new int[4]);
        for (Integer winningCount : winningCounts) {
            statistics = initStatistics.calculateStatistics(winningCount);
        }

        // then
        Assertions.assertThat(statistics).isEqualToComparingFieldByField(expectStatistics);
    }
}