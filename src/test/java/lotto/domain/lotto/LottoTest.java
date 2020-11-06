package lotto.domain.lotto;

import lotto.domain.exception.InvalidCountLottoNumbersException;
import lotto.domain.exception.InvalidRangeLottoNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

    @DisplayName("로또 생성시 숫자가 0이하이거나 45보다 큰 경우")
    @ParameterizedTest
    @MethodSource("getInvalidRangeNumbers")
    public void makeLottoWithInvalidRangeNumber(List<Integer> invalidRangeNumbers) {
        assertThatThrownBy(() -> {
            Lotto.ofNumbers(invalidRangeNumbers);
        }).isInstanceOf(InvalidRangeLottoNumbersException.class)
                .hasMessageContaining("로또 숫자는 1이상 45이하여야 합니다.");
    }

    static Stream<Arguments> getInvalidRangeNumbers() {
        return Stream.of(
                arguments(Arrays.asList(0, 2, 3, 4, 5, 45)),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 46))
        );
    }
}