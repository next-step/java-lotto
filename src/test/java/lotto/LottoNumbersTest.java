package lotto;

import org.junit.jupiter.api.DisplayName;
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
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    private static final String DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE = "로또 번호는 중복 없이 6자리여야 합니다.";

    @Test
    @DisplayName("LottoNumbers 객체를 생성한다")
    void shouldCreateSameObject() {
        HashSet<Integer> input = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = LottoNumbers.from(input);

        assertThat(lottoNumbers).isEqualTo(LottoNumbers.from(input));
    }

    @ParameterizedTest
    @MethodSource("createLottoNumbers")
    @DisplayName("로또 번호가 6자리가 아니면 LottoNumbers를 생성할 수 없다")
    void shouldThrowWhenInputNotSixNumbers(HashSet<Integer> input) {
        assertThatThrownBy(() -> LottoNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("로또 번호가 비어있으면 LottoNumbers를 생성할 수 없다")
    void shouldThrowWhenInputIsEmpty() {
        assertThatThrownBy(() -> LottoNumbers.from(Collections.emptySet()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("로또 번호가 null이면 LottoNumbers를 생성할 수 없다")
    void shouldThrowWhenInputIsNull(HashSet<Integer> input) {
        assertThatThrownBy(() -> LottoNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("로또 번호가 중복이면 LottoNumbers를 생성할 수 없다")
    void shouldThrowWhenHasDuplicateNumber() {
        Set<Integer> duplicateNumbers = new HashSet<>(Arrays.asList(1, 1, 2, 3, 4, 5));

        assertThatThrownBy(() -> LottoNumbers.from(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE);
    }

    private static Stream<Set<Integer>> createLottoNumbers() {
        return Stream.of(
                new HashSet<>(singletonList(1)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }
}