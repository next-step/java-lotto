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

    @DisplayName("통계 데이터를 요청하면, 데이터에 상관없이 이하 형태의 리스트 데이터를 가져온다."
        + "맞춘 개수 당 통계 데이터 1줄(3, 4, 5, 6)씩 총 4행")
    @Test
    void dataSizeTest() {
        RandomLottoCreator creator = new RandomLottoCreator();
        List<Lotto> lottos = Stream.generate(creator::create)
                                   .limit(5)
                                   .collect(toList());

        LottoStatistics lottoStatistics = new LottoStatistics(creator.create(), lottos);
        assertEquals(4, lottoStatistics.getStatistics().size());
    }

    @DisplayName("총 수익율 검증")
    @MethodSource("earningRateTestCase")
    @ParameterizedTest
    void earningRateTest(List<Integer> numbers, int prize) {

        LottoCreator creator = () -> Lotto.of(numbers, LottoNumber.of(45));
        List<Lotto> lottos = Stream.generate(creator::create)
                                   .limit(5)
                                   .collect(toList());

        LottoStatistics lottoStatistics =
            new LottoStatistics(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), LottoNumber.of(45)), lottos);

        double expected = (double) prize * 5 / 5000;
        assertEquals(expected, lottoStatistics.getEarningsRate(lottos.size() * 1000));
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> earningRateTestCase() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), WinningType.find(6).getPrize()),
            Arguments.of(Arrays.asList(2, 3, 4, 5, 6, 7), WinningType.find(5).getPrize()),
            Arguments.of(Arrays.asList(3, 4, 5, 6, 7, 8), WinningType.find(4).getPrize()),
            Arguments.of(Arrays.asList(4, 5, 6, 7, 8, 9), WinningType.find(3).getPrize())
        );
    }
}
