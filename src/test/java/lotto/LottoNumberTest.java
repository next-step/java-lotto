package lotto;

import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.model.WinningNumber;

public class LottoNumberTest {

    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    void match(List<Integer> winningNumbers, int expectedMatchCount) {
        LottoNumber lottoNumber = new LottoNumber(List.of(1,2,3,4,5,6));

        Assertions.assertThat(lottoNumber.match(WinningNumber.of(winningNumbers)))
                  .isEqualTo(LottoMatchResult.of(expectedMatchCount));
    }

    private static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,10,11,12), 3)
        );
    }
}
