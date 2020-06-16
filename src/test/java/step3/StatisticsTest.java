package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 통계 맵 클래스 테스트")
class StatisticsTest {

    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6})
    @DisplayName("1,2,3,4 등 맞춘 개수 셋팅 확인 테스트")
    void initMapTest(int input) {
        Statistics statistics = new Statistics(Arrays.asList(3,4,5,6));
        Map<WinningStatistics, Integer> statisticsMap = statistics.getStatistics();
        assertThat(statisticsMap).containsKeys(WinningStatistics.valueOfWinningCount(input));
    }
}