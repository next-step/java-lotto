package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.model.BonusNumber;
import lotto.model.WinningNumber;

public class LottosTest {

    @DisplayName("주어진 당첨번호와 비교한다")
    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    void match(List<Integer> winningNumbers, int expectedMatchCount) {
        Lottos lotto = new Lottos(List.of(1,2,3,4,5,6));

        assertThat(lotto.match(WinningNumber.of(winningNumbers), BonusNumber.of(1)))
                  .isEqualTo(LottoMatchResult.of(expectedMatchCount, true));
    }

    private static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,10,11,12), 3)
        );
    }
}
