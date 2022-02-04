package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    @DisplayName("담첨 번호 정상 생성.")
    @Test
    void 생성자() {
        // given
        final String input = "1,2,3,4,5,6";

        // then
        assertDoesNotThrow(() -> new WinningNumbers(input));
    }

    @DisplayName("입력형식 (숫자 + 구분자) 이 아닌 경우")
    @ValueSource(strings = {"1;2;3;4;5;6", "123456", "1,2,3,4,5,a"})
    @ParameterizedTest
    void InputFormat(final String input) {
        // then
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(input));
    }

    @DisplayName("숫자 개수가 6개가 아닌 경우")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    @ParameterizedTest
    void NumberCount(final String input) {
        // then
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(input));
    }

    @DisplayName("숫자 범위가 1 ~ 45 가 아닌 경우")
    @ValueSource(strings = {"1,2,3,4,5,46", "0,1,2,3,4,5"})
    @ParameterizedTest
    void NumberRange(final String input) {
        // then
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(input));
    }
}
