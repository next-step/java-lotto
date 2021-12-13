package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    private static final String LOTTO_NUMBER_DIGITS_EXCEPTION_MESSAGE = "로또 번호는 6자리여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATED_EXCEPTION_MESSAGE = "로또 번호는 중복이 없어야 합니다.";

    @Test
    @DisplayName("LottoNumbers 객체를 생성한다")
    void shouldCreateSameObject() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = LottoNumbers.from(input);

        assertThat(lottoNumbers).isEqualTo(LottoNumbers.from(input));
    }

    @ParameterizedTest
    @MethodSource("createLottoNumbers")
    @DisplayName("로또 번호가 6자리가 아니면 LottoNumbers를 생성할 수 없다")
    void shouldThrowWhenInputNotSixNumbers(List<Integer> input) {
        assertThatThrownBy(() -> LottoNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_DIGITS_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("로또 번호가 null이거나 비어있으면 LottoNumbers를 생성할 수 없다")
    void shouldThrowWhenInputIsEmpty(List<Integer> input) {
        assertThatThrownBy(() -> LottoNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_DIGITS_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("로또 번호가 중복이면 LottoNumbers를 생성할 수 없다")
    void shouldThrowWhenHasDuplicateNumber() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 1, 2, 3, 4, 5);

        assertThatThrownBy(() -> LottoNumbers.from(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_DUPLICATED_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 로또 번호 개수를 구한다")
    void shouldReturnCount() {
        LottoNumbers lottoNumbers = LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers winningNumbers = LottoNumbers.from(Arrays.asList(1, 2, 3, 7, 8, 9));

        boolean result = lottoNumbers.match(winningNumbers, count -> count == 3);
        assertThat(result).isTrue();
    }

    private static Stream<List<Integer>> createLottoNumbers() {
        return Stream.of(
                singletonList(1),
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7)
        );
    }
}