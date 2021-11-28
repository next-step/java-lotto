package lotto.lottogame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.*;
import static lotto.lottogame.domain.LottoGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private Lotteries lotteries;

    @BeforeEach
    @DisplayName("랜덤값이 아닌 로또번호를 지정해서 테스트")
    void init() {
        Lotto lotto1 = createManualLotto(asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = createManualLotto(asList(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = createManualLotto(asList(13, 14, 15, 16, 17, 18));
        Lotto lotto4 = createManualLotto(asList(19, 20, 21, 22, 23, 24));
        Lotto lotto5 = createManualLotto(asList(24, 25, 26, 27, 28, 29));
        Lotto lotto6 = createManualLotto(asList(30, 31, 32, 33, 34, 45));
        Lotto lotto7 = createManualLotto(asList(30, 31, 32, 33, 34, 45));

        lotteries = new Lotteries(asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7));
    }


    @ParameterizedTest
    @MethodSource("provideWinnerNumberCount")
    @DisplayName("당첨 통계 - Rank 별 당첨 개수 Map 저장")
    void createLottoStatistics(List<Integer> winningNumbers, Rank rank, int value) {
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 12);
        LottoStatistics lottoStatistics = winningLotto.createLottoStatistics(lotteries, new OrderPrice(14000));
        assertThat(lottoStatistics.getLottoStatistics().get(rank)).isEqualTo(value);
    }

    private static Stream<Arguments> provideWinnerNumberCount() {
        return Stream.of(
                Arguments.of(asList(1, 2, 3, 43, 44, 45), Rank.FIFTH, 1),
                Arguments.of(asList(1, 2, 3, 4, 44, 45), Rank.FOURTH, 1),
                Arguments.of(asList(7, 8, 9, 10, 11, 45), Rank.SECOND, 1),
                Arguments.of(asList(19, 20, 21, 22, 23, 15), Rank.THIRD, 1),
                Arguments.of(asList(30, 31, 32, 33, 34, 45), Rank.FIRST, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideWinnerNumberRate")
    @DisplayName("통계 Map 을 이용한 총 수익률 계산")
    void getRateOfReturn(List<Integer> winningNumbers, int bonusBall, double rate) {
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);
        LottoStatistics lottoStatistics = winningLotto.createLottoStatistics(lotteries, new OrderPrice(14000));
        assertThat(lottoStatistics.calculateRateOfProfit()).isEqualTo(rate);
    }

    private static Stream<Arguments> provideWinnerNumberRate() {
        return Stream.of(
                Arguments.of(asList(1, 2, 3, 43, 44, 45), 4, 0.35),          // 3개일치 - 5등 1명
                Arguments.of(asList(7, 8, 9, 10, 44, 45), 1, 3.57),          // 4개일치 - 4등 1명
                Arguments.of(asList(13, 14, 15, 16, 17, 45), 1, 107.14),     // 5개일치 - 3등 1명
                Arguments.of(asList(13, 14, 15, 16, 17, 45), 18, 2142.85),   // 5개일치 - 2등 1명
                Arguments.of(asList(19, 20, 21, 22, 23, 24), 1, 142857.14),  // 6개일치 - 1등 1명
                Arguments.of(asList(1, 2, 3, 7, 8, 9), 44, 0.71),            // 3개,3개 - 5등 2명
                Arguments.of(asList(22, 23, 24, 25, 26, 27), 1, 3.92),       // 3개,4개 - 4등 1명, 5등 1명
                Arguments.of(asList(30, 31, 32, 33, 43, 45), 34, 4285.71)    // 5개,5개 - 2등 2명
        );
    }


}