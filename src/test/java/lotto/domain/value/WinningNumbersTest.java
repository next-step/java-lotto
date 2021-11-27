package lotto.domain.value;

import lotto.exception.WinningNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @DisplayName("당첨번호 개수가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    void validateCreateWinningNumbers() {
        List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 6);

        assertThatThrownBy(() -> WinningNumbers.of(numbers)).isInstanceOf(WinningNumberException.class);
    }

}