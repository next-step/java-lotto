package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @ParameterizedTest
    @MethodSource("createLottoNumbers")
    void shouldThrowWhenInputNotSixNumbers(List<Integer> input) {
        assertThatThrownBy(() -> LottoNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자는 6자리여야 합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowWhenInputEmptyOrNull(List<Integer> input) {
        assertThatThrownBy(() -> LottoNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자는 6자리여야 합니다.");
    }

    private static Stream<List<Integer>> createLottoNumbers() {
        return Stream.of(
                singletonList(1),
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7)
        );
    }
}