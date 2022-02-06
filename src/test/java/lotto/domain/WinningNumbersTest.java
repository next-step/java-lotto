package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    @DisplayName("정상적인 입력을 가지고 당첨 번호 객체를 생성할 때 예외가 발생하지 않는다.")
    @Test
    void Given_정상_입력_When_객체_생성_Then_예외가_발생하지_않음() {
        // given
        final String input = "1,2,3,4,5,6";

        // then
        assertDoesNotThrow(() -> new WinningNumbers(input));
    }

    @DisplayName("입력형식 (숫자 + 구분자) 이 아니면 예외가 발생한다.")
    @ValueSource(strings = {"1;2;3;4;5;6", "123456", "1,2,3,4,5,a"})
    @ParameterizedTest
    void Given_유효하지_않은_입력형식_When_객체_생성_Then_예외_발생(final String input) {
        // then
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(input));
    }

    @DisplayName("숫자 개수가 6개가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    @ParameterizedTest
    void Given_숫자가_6개가_아닌_입력_When_객체_생성_Then_예외_발생(final String input) {
        // then
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(input));
    }

    @DisplayName("숫자 범위가 1 ~ 45 가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"1,2,3,4,5,46", "0,1,2,3,4,5"})
    @ParameterizedTest
    void Given_로또_번호_범위를_벗어난_입력_When_객체_생성_Then_예외_발생(final String input) {
        // then
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(input));
    }

    @DisplayName("숫자 사이 공백이 있는 경우 공백을 제거하고 해석한다.")
    @Test
    void Given_공백이_있는_입력_When_객체_생성_Then_공백을_제거하고_해석_하여_정상_생성() {
        // given
        String input = "1, 2, 3, 4, 5, 6";
        // then
        assertDoesNotThrow(() -> new WinningNumbers(input));
    }
}
