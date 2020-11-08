package lotto.domain.lotto;

import lotto.domain.exception.InvalidCountLottoNumbersException;
import lotto.domain.exception.InvalidDuplicatedLottoNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("로또 도메인 테스트")
public class LottoTest {
    @DisplayName("로또 생성시 숫자가 6개가 아닌 경우")
    @ParameterizedTest
    @MethodSource("getInvalidCountNumbers")
    public void makeLottoWithInvalidCountNumbers(List<Integer> invalidCountNumbers) {
        assertThatThrownBy(() -> {
            Lotto.ofNumbers(invalidCountNumbers);
        }).isInstanceOf(InvalidCountLottoNumbersException.class)
                .hasMessageContaining("로또 숫자는 6개여야 합니다.");
    }

    static Stream<Arguments> getInvalidCountNumbers() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 4, 5)),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }


    @DisplayName("당첨된 숫자 개수")
    @ParameterizedTest
    @MethodSource("getLastLottoNumbers")
    public void getWinningCount(List<Integer> lastLottoNumbers, Integer expectedWinningCount) {
        Lotto lotto = Lotto.ofNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        Integer winningCount = lotto.getWinningCount(Lotto.ofNumbers(lastLottoNumbers));

        assertThat(winningCount).isEqualTo(expectedWinningCount);
    }

    static Stream<Arguments> getLastLottoNumbers() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 45), 5),
                arguments(Arrays.asList(1, 2, 3, 4, 44, 45), 4),
                arguments(Arrays.asList(1, 2, 3, 43, 44, 45), 3),
                arguments(Arrays.asList(1, 2, 42, 43, 44, 45), 2),
                arguments(Arrays.asList(1, 41, 42, 43, 44, 45), 1),
                arguments(Arrays.asList(40, 41, 42, 43, 44, 45), 0)
        );
    }

    @DisplayName("중복된 로또 숫자")
    @ParameterizedTest
    @MethodSource("getDuplicatedLottoNumbers")
    public void duplicatedLottoNumber(List<Integer> duplicatedNumbers) {
        assertThatThrownBy(() -> {
            Lotto.ofNumbers(duplicatedNumbers);
        }).isInstanceOf(InvalidDuplicatedLottoNumbersException.class)
                .hasMessageContaining("로또 숫자는 6개 모두 중복이 없여야 합니다.");
    }

    static Stream<Arguments> getDuplicatedLottoNumbers() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 4, 5, 1)),
                arguments(Arrays.asList(1, 1, 1, 1, 1, 1))
        );
    }
}