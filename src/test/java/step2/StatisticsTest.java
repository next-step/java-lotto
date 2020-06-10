package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 통계 맵 클래스 테스트")
class StatisticsTest {

    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6})
    @DisplayName("1,2,3,4 등 맞춘갯수 셋팅 확인 테스트")
    void initMapTest(int input) {
        Statistics statistics = new Statistics();
        Map<Integer, Integer> statisticsMap = statistics.getStatistics();
        assertThat(statisticsMap).containsKeys(input);
    }

    @Test
    @DisplayName("당첨 등수 추가했을때 당첨 금액 확인 테스트")
    void getTotalPriceTest(int input) {
        int totalPrice = 5000 + 50000;
        Statistics statistics = new Statistics();
        statistics.addCount(3);
        statistics.addCount(4);
        assertThat(totalPrice).isEqualTo(statistics.getTotalPrice());
    }
}