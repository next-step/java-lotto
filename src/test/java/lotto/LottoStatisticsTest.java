package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @ParameterizedTest(name = "[{index}] statistics: {0}, lottoResult: {1}, expectedCount: {2}")
    @MethodSource("provideGetCountTestCases")
    @DisplayName("getCount 테스트")
    void testGetCount(Map<LottoResult, Integer> statistics, LottoResult lottoResult, int expectedCount) {
        LottoStatistics lottoStatistics = LottoStatistics.getStatistics(1000, statistics);
        int count = lottoStatistics.getCount(lottoResult);
        assertThat(count).isEqualTo(expectedCount);
    }

    static Stream<Arguments> provideGetCountTestCases() {
        return Stream.of(
                Arguments.of(Map.of(LottoResult.FIRST, 3, LottoResult.SECOND, 1), LottoResult.FIRST, 3),
                Arguments.of(Map.of(LottoResult.FIRST, 3, LottoResult.SECOND, 1), LottoResult.SECOND, 1),
                Arguments.of(Map.of(LottoResult.FIRST, 3), LottoResult.SECOND, 0)
        );
    }

    @ParameterizedTest(name = "[{index}] lottoPrice: {0}, statistics: {1}, expectedYield: {2}")
    @MethodSource("provideCalculateYieldTestCases")
    @DisplayName("calculateYield 테스트")
    void testCalculateYield(int lottoPrice, Map<LottoResult, Integer> statistics, String expectedYield) {
        LottoStatistics lottoStatistics = LottoStatistics.getStatistics(lottoPrice, statistics);
        String yield = lottoStatistics.calculateYield();
        assertThat(yield).isEqualTo(expectedYield);
    }

    static Stream<Arguments> provideCalculateYieldTestCases() {
        return Stream.of(
                Arguments.of(15000, Map.of(), "0.00"),
                Arguments.of(15000, Map.of(LottoResult.FOURTH, 1), "0.33"),
                Arguments.of(15000, Map.of(LottoResult.NONE, 2, LottoResult.SECOND, 1), "100.00")
        );
    }
}

