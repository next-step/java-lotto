package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import lotto.domain.lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 팩토리")
class LottoFactoryTest {

    public static Stream<Arguments> validLottoNumbers() {
        return Stream.of(
            Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 7),
            Arguments.of(new HashSet<>(Arrays.asList(1, 2, 4, 15, 20, 45)), 44)
        );
    }

    @DisplayName("[성공] 당첨 로또 생성")
    @ParameterizedTest
    @MethodSource("validLottoNumbers")
    public void createWinning(Set<Integer> numbers, int bonusNumber) {
        // given

        // when
        WinningLotto winningLotto = LottoFactory.createWinning(numbers, bonusNumber);

        // then
        assertThat(winningLotto).isNotNull();
    }

    public static Stream<Arguments> notValidLottoNumbers() {
        return Stream.of(
            Arguments.of(new HashSet<>(Arrays.asList(10, 1, 2, 3, 4, 5)), 5),
            Arguments.of(new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5)), 6),
            Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 5)), 6),
            Arguments.of(new HashSet<>(Arrays.asList(0, 5, 6, 7, 15, 46)), 9),
            Arguments.of(new HashSet<>(Arrays.asList(1, 2, 6, 7)), 10)
        );
    }

    @DisplayName("[실패] 당첨 로또 생성 - 유효하지 않은 로또 번호")
    @ParameterizedTest
    @MethodSource("notValidLottoNumbers")
    public void createWinning_notValid(Set<Integer> numbers, int bonusNumber) {
        // given

        // when
        Assertions.assertThrows(InvalidLottoNumberException.class, () -> LottoFactory.createWinning(numbers, bonusNumber));

        // then

    }
}
