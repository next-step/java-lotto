package step3.lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.LottoTestHelper;
import step3.lotto.Lotto;
import step3.lotto.Rank;
import step3.lotto.TotalLottoNumber;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {

    @ParameterizedTest
    @MethodSource("params")
    @DisplayName("로또 결과 검증 테스트")
    void test(TotalLottoNumber totalLottoNumber, Lotto lotto, Rank expectedRank) {
        LottoResult lottoResult = new LottoResult(totalLottoNumber, lotto);

        assertEquals(expectedRank, lottoResult.getRank());
    }

    private static Stream<Arguments> params() {
        TotalLottoNumber totalLottoNumber = LottoTestHelper.generateTotalLottoNumber();
        return Stream.of(
                Arguments.of(totalLottoNumber, LottoTestHelper.generateFixedNumberLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), Rank.FIRST),
                Arguments.of(totalLottoNumber, LottoTestHelper.generateFixedNumberLotto(Arrays.asList(1, 2, 3, 4, 5, 7)), Rank.SECOND),
                Arguments.of(totalLottoNumber, LottoTestHelper.generateFixedNumberLotto(Arrays.asList(1, 2, 3, 4, 5, 8)), Rank.THIRD),
                Arguments.of(totalLottoNumber, LottoTestHelper.generateFixedNumberLotto(Arrays.asList(1, 2, 3, 4, 8, 9)), Rank.FOURTH),
                Arguments.of(totalLottoNumber, LottoTestHelper.generateFixedNumberLotto(Arrays.asList(1, 2, 3, 7, 8, 9)), Rank.FIFTH)
        );
    }
}
