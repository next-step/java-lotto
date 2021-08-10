package step2.lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.LottoTestHelper;
import step2.lotto.Lotto;
import step2.lotto.LottoNumber;
import step2.lotto.LottoPrize;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {

    @ParameterizedTest
    @MethodSource("params")
    @DisplayName("로또 결과 검증 테스트")
    void test(LottoNumber winningNumber, Lotto lotto, long expectedCountOfMatches, LottoPrize expectedLottoPrize) {
        LottoResult lottoResult = new LottoResult(winningNumber, lotto);

        long actualCountOfMatches = lottoResult.getCountOfMatches();
        LottoPrize actualLottoPrize = lottoResult.getLottoPrize();

        assertEquals(expectedCountOfMatches, actualCountOfMatches);
        assertEquals(expectedLottoPrize, actualLottoPrize);
    }

    private static Stream<Arguments> params() {
        LottoNumber winningNumber = LottoTestHelper.generateLottoNumber();
        return Stream.of(
                Arguments.of(winningNumber, LottoTestHelper.generateFixedNumberLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), Lotto.COUNT_OF_MATCHES_FIRST, LottoPrize.FIRST),
                Arguments.of(winningNumber, LottoTestHelper.generateFixedNumberLotto(Arrays.asList(1, 2, 3, 4, 5, 7)), Lotto.COUNT_OF_MATCHES_SECOND, LottoPrize.SECOND),
                Arguments.of(winningNumber, LottoTestHelper.generateFixedNumberLotto(Arrays.asList(1, 2, 3, 4, 7, 8)), Lotto.COUNT_OF_MATCHES_THIRD, LottoPrize.THIRD),
                Arguments.of(winningNumber, LottoTestHelper.generateFixedNumberLotto(Arrays.asList(1, 2, 3, 7, 8, 9)), Lotto.COUNT_OF_MATCHES_FOURTH, LottoPrize.FOURTH)
        );
    }
}
