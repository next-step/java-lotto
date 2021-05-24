package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static lotto.domain.WinningType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoStatisticsTest {

    @DisplayName("통계 데이터를 요청하면 1등부터 5등에 해당하는 데이터 목록을 가져온다.")
    @Test
    void dataSizeTest() {
        List<WinningType> types = Arrays.asList(NONE, FIFTH, FIRST);
        LottoStatistics lottoStatistics = new LottoStatistics(types);
        assertEquals(5, lottoStatistics.getStatisticsData().size());
    }

    @DisplayName("총 수익율 검증")
    @MethodSource("earningRateTestCase")
    @ParameterizedTest
    void earningRateTest(List<WinningType> types) {

        LottoStatistics lottoStatistics = new LottoStatistics(types);

        long totalPrize = types.stream()
                               .mapToLong(WinningType::getPrize)
                               .sum();

        double expected = (double) totalPrize / (types.size() * Money.LOTTO_PRICE);

        assertEquals(expected, lottoStatistics.getEarningsRate(types.size()));
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> earningRateTestCase() {
        return Stream.of(
            Arguments.of(Arrays.asList(FIRST, SECOND, THIRD)),
            Arguments.of(Arrays.asList(FIFTH, FIFTH, FIFTH)),
            Arguments.of(Arrays.asList(FIRST, FIRST, FIRST, FIRST, FIRST))
        );
    }
}
