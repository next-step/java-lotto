package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoStatisticsTest {

    @DisplayName("통계 데이터를 요청하면 1등부터 5등에 해당하는 데이터 목록을 가져온다.")
    @Test
    void dataSizeTest() {
        RandomLottoCreator creator = new RandomLottoCreator();
        List<Lotto> lottos = Stream.generate(creator::create)
                                   .limit(5)
                                   .collect(toList());

        LottoStatistics lottoStatistics = new LottoStatistics(creator.create(), lottos);
        assertEquals(5, lottoStatistics.getStatisticsData().size());
    }

    @DisplayName("총 수익율 검증")
    @MethodSource("earningRateTestCase")
    @ParameterizedTest
    void earningRateTest(List<Integer> numbers, int bonusNumber, int prize) {

        LottoCreator creator = () -> Lotto.of(numbers, LottoNumber.of(bonusNumber));
        List<Lotto> lottos = Stream.generate(creator::create)
                                   .limit(5)
                                   .collect(toList());

        Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), LottoNumber.of(45));
        LottoStatistics lottoStatistics = new LottoStatistics(winningLotto, lottos);

        double expected = (double) prize * 5 / 5000;
        assertEquals(expected, lottoStatistics.getEarningsRate(lottos.size()));
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> earningRateTestCase() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 40, WinningType.FIRST.getPrize()),
            Arguments.of(Arrays.asList(2, 3, 4, 5, 6, 7), 45, WinningType.SECOND.getPrize()),
            Arguments.of(Arrays.asList(2, 3, 4, 5, 6, 7), 40, WinningType.THIRD.getPrize()),
            Arguments.of(Arrays.asList(3, 4, 5, 6, 7, 8), 40, WinningType.FOURTH.getPrize()),
            Arguments.of(Arrays.asList(4, 5, 6, 7, 8, 9), 40, WinningType.FIFTH.getPrize())
        );
    }
}
