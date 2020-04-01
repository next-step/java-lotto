package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.LottoProvider;
import step2.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {

    @Test
    @DisplayName("입력받은 보너스 번호가 로또 번호와 중복되지 않아야 함을 검증한다.")
    void validateWinningLotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoProvider.createWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        }).withMessage(WinningLotto.BONUS_NUMBER_DUPLICATION_ERROR);
    }

    @DisplayName("당첨 숫자 개수 체크가 제대로 되는지 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    void WinningNumber(List<Integer> input, int expected) {
        WinningLotto lotto = LottoProvider.createWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(input))).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 7, 8), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 7, 8, 9), 3),
                Arguments.of(Arrays.asList(1, 2, 7, 8, 9, 10), 2),
                Arguments.of(Arrays.asList(1, 7, 8, 9, 10, 11), 1),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), 0)
        );
    }
}
