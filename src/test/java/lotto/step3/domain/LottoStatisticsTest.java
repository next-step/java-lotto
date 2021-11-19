package lotto.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private Lotteries lotteries;

    @BeforeEach
    void init() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18));
        Lotto lotto4 = new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24));
        Lotto lotto5 = new Lotto(Arrays.asList(24, 25, 26, 27, 28, 29));
        Lotto lotto6 = new Lotto(Arrays.asList(30, 31, 32, 33, 34, 45));
        Lotto lotto7 = new Lotto(Arrays.asList(30, 31, 32, 33, 34, 43));
        lotteries = new Lotteries(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7));
    }

    @ParameterizedTest
    @MethodSource("provideWinnerNumberRate")
    @DisplayName("당첨번호와 비교 했을때, 로또구매 금액과 당첨수에 따른 총 수익률 계산")
    void getRateOfReturn(Lotto provided, int bonusBall, double rate) {
        LottoStatistics lottoStatistics = new LottoStatistics(lotteries, provided, bonusBall);
        assertThat(lottoStatistics.calculateRateOfProfit(14000)).isEqualTo(rate);
    }

    private static Stream<Arguments> provideWinnerNumberRate() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45)), 1, 0.35),          // 3개일치 - 5등 1명
                Arguments.of(new Lotto(Arrays.asList(7, 8, 9, 10, 44, 45)), 7, 3.57),          // 4개일치 - 4등 1명
                Arguments.of(new Lotto(Arrays.asList(13, 14, 15, 16, 17, 45)), 45, 107.14),    // 5개일치 - 3등 1명
                Arguments.of(new Lotto(Arrays.asList(13, 14, 15, 16, 17, 45)), 17, 2142.85),   // 5개일치 - 2등 1명
                Arguments.of(new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24)), 19, 142857.14), // 6개일치 - 1등 1명
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)), 1, 0.71),             // 3개,3개 - 5등 2명
                Arguments.of(new Lotto(Arrays.asList(22, 23, 24, 25, 26, 27)), 22, 3.92),      // 3개,4개 - 4등 1명, 5등 1명
                Arguments.of(new Lotto(Arrays.asList(30, 31, 32, 33, 43, 45)), 30, 4285.71)    // 5개,5개 - 2등 2명
        );
    }

}