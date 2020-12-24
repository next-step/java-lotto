package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.domain.WinningLotto.BONUS_NUMBER_DUPLICATE_EXCEPTION_MESSAGE;

public class WinningLottoTest {

    @Test
    @DisplayName("6개의 로또번호와 보너스 번호는 중복되지 않아야 한다.")
    void assertBonusNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoGenerator.generateWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        }).withMessage(BONUS_NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
    }

    @DisplayName("입력받은 로또와 비교하여 LottoTier를 반환한다.")
    @ParameterizedTest
    @MethodSource("getTargetNumbers")
    void getLottoTier(List<Integer> input, LottoTier expected) {
        WinningLotto winningLotto = LottoGenerator.generateWinningLotto(Arrays.asList(1, 2, 3, 4 ,5 ,6), 7);
        Lotto inputLotto = LottoGenerator.generateLotto(input);

        assertThat(winningLotto.getLottoTier(inputLotto)).isEqualTo(expected);
    }

    private static Stream<Arguments> getTargetNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), LottoTier.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), LottoTier.SECOND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 8), LottoTier.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 8, 9), LottoTier.FOURTH),
                Arguments.of(Arrays.asList(1, 2, 3, 8, 9, 10), LottoTier.FIFTH),
                Arguments.of(Arrays.asList(1, 2, 8, 9, 10, 11), LottoTier.NONE),
                Arguments.of(Arrays.asList(1, 8, 9, 10, 11, 12), LottoTier.NONE),
                Arguments.of(Arrays.asList(8, 9, 10, 11, 12, 13), LottoTier.NONE)
        );
    }
}
