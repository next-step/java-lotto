package lotto.domains;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoStatisticsTest {
    @ParameterizedTest
    @MethodSource("testGetYieldSource")
    void testGetYield(List<Lotto> lottoList, Lotto lastWinner, double expected) {
        LottoStatistics statistics = new LottoStatistics(lottoList, lastWinner);

        assertThat(statistics.getYield()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testGetWinningCountSource")
    void testGetWinningCount(List<Lotto> lottoList, Lotto lastWinner, Prize prize, long expectedWinningCount) {
        LottoStatistics statistics = new LottoStatistics(lottoList, lastWinner);

        assertThat(statistics.getWinningCount(prize)).isEqualTo(expectedWinningCount);
    }

    static Stream<Arguments> testGetYieldSource() {
        return Stream.of(
                arguments(
                        List.of(
                                new Lotto(1, 2, 3, 4, 5, 6),
                                new Lotto(1, 2, 3, 10 ,11, 12)
                        ),
                        new Lotto(1, 2, 3, 4, 5, 6),
                        (Prize.FIRST.getReward() + Prize.FOURTH.getReward()) / ((double) LottoGenerator.LOTTO_PRICE * 2)
                ),
                arguments(
                        List.of(),
                        new Lotto(1, 2, 3, 4, 5, 6),
                        0
                )
        );
    }

    static Stream<Arguments> testGetWinningCountSource() {
        return Stream.of(
                arguments(
                        List.of(
                                new Lotto(1, 2, 3, 4, 5, 6),
                                new Lotto(1, 2, 3, 10 ,11, 12)
                        ),
                        new Lotto(1, 2, 3, 4, 5, 6),
                        Prize.FIRST,
                        1
                ),
                arguments(
                        List.of(),
                        new Lotto(1, 2, 3, 4, 5, 6),
                        Prize.FIRST,
                        0
                )
        );
    }
}
