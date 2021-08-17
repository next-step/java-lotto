package step3.lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.LottoTestHelper;
import step3.lotto.Rank;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultStatisticTest {

    @ParameterizedTest
    @DisplayName("countOfRank 테스트")
    @MethodSource("param")
    void countOfRankTest(Rank rank, long count) {
        LottoResults lottoResults = LottoTestHelper.generateLottoResults(rank, count);
        ResultStatistic resultStatistic = new ResultStatistic(0.1, lottoResults);
        long actual = resultStatistic.countOfRank(rank);
        assertEquals(count, actual);
    }


    private static Stream<Arguments> param() {
        return Stream.of(
                Arguments.of(Rank.FIFTH, 11),
                Arguments.of(Rank.FIFTH, 21),
                Arguments.of(Rank.FIFTH, 5),
                Arguments.of(Rank.FIFTH, 15)
        );
    }
}