package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 통계 맵 클래스 테스트")
class StatisticsTest {

    @ParameterizedTest
    @MethodSource("provideTestParameter")
    @DisplayName("1,2,3,4 등 맞춘 개수 셋팅 확인 테스트")
    void initMapTest(int winningCount, boolean hasBonus) {

        List<LottoResult> lottoResults = Arrays.asList(new LottoResult(3, false)
                , new LottoResult(5, false)
                , new LottoResult(5, true)
                , new LottoResult(6, false));
        Statistics statistics = new Statistics(lottoResults);
        Map<WinningStatistics, Integer> statisticsMap = statistics.getStatistics();
        assertThat(statisticsMap).containsKeys(WinningStatistics.valueOfWinningCount(winningCount, true));
    }

    private static Stream<Arguments> provideTestParameter() {
        return Stream.of(
          Arguments.of(4, false),
          Arguments.of(5, false),
          Arguments.of(5, true),
          Arguments.of(6, false)
        );
    }
}