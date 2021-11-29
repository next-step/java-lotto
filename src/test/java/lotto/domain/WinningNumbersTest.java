package lotto.domain;

import lotto.exception.EmptySourceException;
import lotto.exception.WinningNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @DisplayName("공백이나, null이 입력될 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateEmptySource(String input) {
        assertThatThrownBy(() -> WinningNumbers.of(input)).isInstanceOf(EmptySourceException.class);
    }


    @DisplayName("당첨번호 개수가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    void validateSize() {
        String input = "1, 3, 4, 5, 6";

        assertThatThrownBy(() -> WinningNumbers.of(input)).isInstanceOf(WinningNumberException.class);
    }

    @DisplayName("당첨번호중 45를 넘는 숫자가 있을경우 예외가 발생한다.")
    @Test
    void validateNumbers() {
        String input = "1, 3, 4, 5, 7, 46";

        assertThatThrownBy(() -> WinningNumbers.of(input)).isInstanceOf(WinningNumberException.class);
    }

    @DisplayName("음수가 있을경우 예외가 발생한다.")
    @Test
    void validateNegativeNumber() {
        String input = "1, 3, 4, -5, 6, 7";

        assertThatThrownBy(() -> WinningNumbers.of(input)).isInstanceOf(WinningNumberException.class);
    }

}