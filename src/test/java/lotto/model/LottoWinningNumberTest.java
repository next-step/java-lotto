package lotto.model;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinningNumberTest {

    private static Stream<Arguments> prizeTestGenerator() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), LottoPrize.FIRST),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), LottoPrize.SECOND),
                Arguments.of(List.of(10, 2, 3, 4, 5, 6), LottoPrize.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 8, 9), LottoPrize.THIRD),
                Arguments.of(List.of(1, 20, 3, 10, 5, 12), LottoPrize.FOURTH),
                Arguments.of(List.of(1, 2, 13, 14, 15, 16), LottoPrize.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource("prizeTestGenerator")
    void 결과_판단(List<Integer> numbers, LottoPrize expectedPrize) {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lotto myLotto = new Lotto(numbers);

        LottoPrize rank = lottoWinningNumber.getRank(myLotto);

        Assertions.assertEquals(expectedPrize, rank);
    }

}
