package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @ParameterizedTest
    @MethodSource("createLottoNumbers")
    void shouldThrowWhenInputNotSixNumbers(HashSet<Integer> input) {
        assertThatThrownBy(() -> LottoNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복 없이 6자리여야 합니다.");
    }

    @Test
    void shouldThrowWhenInputIsEmpty() {
        assertThatThrownBy(() -> LottoNumbers.from(Collections.emptySet()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복 없이 6자리여야 합니다.");
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowWhenInputIsNull(HashSet<Integer> input) {
        assertThatThrownBy(() -> LottoNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복 없이 6자리여야 합니다.");
    }

    @Test
    void shouldThrowWhenHasSameNumber() {
        assertThatThrownBy(() -> LottoNumbers.from(new HashSet<>(Arrays.asList(1, 1, 2, 3, 4, 5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복 없이 6자리여야 합니다.");
    }

    private static Stream<Set<Integer>> createLottoNumbers() {
        return Stream.of(
                new HashSet<>(singletonList(1)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }
}