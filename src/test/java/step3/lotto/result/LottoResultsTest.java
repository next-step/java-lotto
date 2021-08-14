package step3.lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.LottoTestHelper;
import step3.lotto.Rank;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoResultsTest {

    @ParameterizedTest
    @DisplayName("당첨상금 합계 테스트")
    @MethodSource("param")
    void sumOfPrizeMoneyTest(LottoResult lottoResult, Rank expectedRank) {
        LottoResults lottoResults = new LottoResults(Arrays.asList(lottoResult));

        assertEquals(expectedRank.getPrizeMoney(), lottoResults.sumOfPrizeMoney());
    }

    private static Stream<Arguments> param() {
        return Stream.of(
                Arguments.of(LottoTestHelper.generateLottoResult(Rank.FIRST), Rank.valueOf(Rank.FIRST.getCountOfMatch(), false)),
                Arguments.of(LottoTestHelper.generateLottoResult(Rank.SECOND), Rank.valueOf(Rank.SECOND.getCountOfMatch(), true)),
                Arguments.of(LottoTestHelper.generateLottoResult(Rank.THIRD), Rank.valueOf(Rank.THIRD.getCountOfMatch(), false)),
                Arguments.of(LottoTestHelper.generateLottoResult(Rank.FOURTH), Rank.valueOf(Rank.FOURTH.getCountOfMatch(), false)),
                Arguments.of(LottoTestHelper.generateLottoResult(Rank.FIFTH), Rank.valueOf(Rank.FIFTH.getCountOfMatch(), false))
        );
    }


}