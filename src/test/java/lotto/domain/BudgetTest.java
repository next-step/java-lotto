package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BudgetTest {

    @DisplayName("정상적인 구매 금액을 받아 객체를 생성하면 예외가 발생하지 않는다.")
    @Test
    void Given_정상_매개변수_When_객체_생성_Then_예외가_발생하지_않음() {
        // given
        final String input = "14000";

        // then
        Assertions.assertDoesNotThrow(() -> new Budget(input));
    }

    @DisplayName("구매 금액에 문자가 포함되어 있으면 예외가 발생한다.")
    @ValueSource(strings = {"1400 0", "aaa", "12a", "12 a"})
    @ParameterizedTest
    void Given_문자가_포함된_금액_문자열_When_객체_생성_Then_예외_발생(final String input) {
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Budget(input));
    }
}
