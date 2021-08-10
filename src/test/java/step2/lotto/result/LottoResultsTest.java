package step2.lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.LottoTestHelper;
import step2.lotto.Lotto;
import step2.lotto.LottoPrize;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoResultsTest {

    @ParameterizedTest
    @DisplayName("당첨상금 합계 테스트")
    @MethodSource("param")
    void sumOfPrizeMoneyTest(LottoResult lottoResult, LottoPrize expectedLottoPrize) {
        LottoResults lottoResults = new LottoResults(Arrays.asList(lottoResult));

        assertEquals(expectedLottoPrize.getPrizeMoney(), lottoResults.sumOfPrizeMoney());
    }

    private static Stream<Arguments> param() {
        return Stream.of(
                Arguments.of(LottoTestHelper.generateLottoResult(Lotto.COUNT_OF_MATCHES_FIRST), LottoPrize.getLottoPrize(Lotto.COUNT_OF_MATCHES_FIRST)),
                Arguments.of(LottoTestHelper.generateLottoResult(Lotto.COUNT_OF_MATCHES_SECOND), LottoPrize.getLottoPrize(Lotto.COUNT_OF_MATCHES_SECOND)),
                Arguments.of(LottoTestHelper.generateLottoResult(Lotto.COUNT_OF_MATCHES_THIRD), LottoPrize.getLottoPrize(Lotto.COUNT_OF_MATCHES_THIRD)),
                Arguments.of(LottoTestHelper.generateLottoResult(Lotto.COUNT_OF_MATCHES_FOURTH), LottoPrize.getLottoPrize(Lotto.COUNT_OF_MATCHES_FOURTH))
        );
    }


}