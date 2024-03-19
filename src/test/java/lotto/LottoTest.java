package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.utils.TestNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private final Lotto winningLotto = new Lotto(new LottoNumbers(new TestNumberGenerator(List.of(1, 2, 3, 4, 5, 6))));

    @ParameterizedTest
    @DisplayName("등수 계산 테스트")
    @MethodSource("getUserNumbersAndLottoResult")
    public void winningTest(List<Integer> userNumbers, Optional<LottoResult> expected) {
        LottoNumbers userLottoNumbers = new LottoNumbers(new TestNumberGenerator(userNumbers));
        Lotto userLotto = new Lotto(userLottoNumbers);

        assertThat(userLotto.isWinningLotto(winningLotto)).isEqualTo(expected);
    }

    private static Stream<Arguments> getUserNumbersAndLottoResult() {
        return Stream.of(
                Arguments.of(List.of(6, 7, 8, 9, 10, 11), Optional.empty()),
                Arguments.of(List.of(5, 6, 7, 8, 9, 10), Optional.empty()),
                Arguments.of(List.of(4, 5, 6, 7, 8, 9), Optional.of(LottoResult.FOURTH)),
                Arguments.of(List.of(3, 4, 5, 6, 7, 8), Optional.of(LottoResult.THIRD)),
                Arguments.of(List.of(2, 3, 4, 5, 6, 7), Optional.of(LottoResult.SECOND)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), Optional.of(LottoResult.FIRST))
        );
    }
}
