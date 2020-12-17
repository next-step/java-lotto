package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LastWinningNumbersTest {

    @Test
    void 지난주_당첨_번호가_6개가_아니면_예외() {
        // given
        List<Integer> lastWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // when
        assertThatThrownBy(() -> {
            LastWinningNumbers.newWinningNumbers(lastWinningNumbers);
            // then
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지난주_당첨_번호가_중복되면_예외() {
        // given
        List<Integer> lastWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        // when
        assertThatThrownBy(() -> {
            LastWinningNumbers.newWinningNumbers(lastWinningNumbers);
            // then
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "지난 주 당첨 번호가 45보다 크거나 1보다 작으면 예외")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 지난주_당첨_번호의_범위_체크(int number) {
        // given
        List<Integer> lastWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, number);

        // when
        assertThatThrownBy(() -> {
            LastWinningNumbers.newWinningNumbers(lastWinningNumbers);
            // then
        }).isInstanceOf(IllegalArgumentException.class);
    }
}