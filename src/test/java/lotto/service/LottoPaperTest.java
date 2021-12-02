package lotto.service;

import lotto.model.WinningPrice;
import lotto.service.LottoNumber;
import lotto.service.LottoPaper;
import lotto.service.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.utils.TestUtils.testLottoNumbers;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoPaperTest {

    @ParameterizedTest
    @MethodSource("provideTestArguments")
    @DisplayName("getWinningPrice 메소드는 로또 당첨 금액을 반환한다")
    void 테스트_getWinningPrice_당첨_금액_반환한다(LottoPaper input, WinningPrice expected) {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(testLottoNumbers(), new LottoNumber(7));

        // when

        // then
        assertThat(input.getWinningPrice(winningNumbers)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTestArguments() { // argument source method
        return Stream.of(
                Arguments.of(new LottoPaper(testLottoNumbers(1,2,3,4,5,6)), WinningPrice.FIRST),
                Arguments.of(new LottoPaper(testLottoNumbers(1,2,3,4,5,7)), WinningPrice.SECOND),
                Arguments.of(new LottoPaper(testLottoNumbers(1,2,3,4,5,8)), WinningPrice.THIRD),
                Arguments.of(new LottoPaper(testLottoNumbers(1,2,3,4,7,8)), WinningPrice.FORTH),
                Arguments.of(new LottoPaper(testLottoNumbers(1,2,3,7,8,9)), WinningPrice.FIFTH),
                Arguments.of(new LottoPaper(testLottoNumbers(1,2,7,8,9,10)), WinningPrice.NOTWIN)
        );
    }
}