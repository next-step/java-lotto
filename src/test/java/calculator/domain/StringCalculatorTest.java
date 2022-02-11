package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    private StringCalculator calculator;

    @DisplayName(value = "숫자 하나로 이루어진 number token을 입력 받으면 해당 숫자를 반환한다.")
    @Test
    void oneNumber() {
        NumberTokens numberTokens = new NumberTokens(1);
        calculator = new StringCalculator(numberTokens);
        assertThat(calculator.createResult(numberTokens.getNumbers())).isSameAs(1);
    }

    @DisplayName(value = "숫자 두 개로 이루어진 number token을 입력 받으면 두 숫자의 합을 반환한다.")
    @Test
    void twoNumbers() {
        NumberTokens numberTokens = new NumberTokens(1,2);
        calculator = new StringCalculator(numberTokens);
        assertThat(calculator.createResult(numberTokens.getNumbers())).isSameAs(3);
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    void negative() {
        NumberTokens numberTokens = new NumberTokens(-1,2);
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new StringCalculator(numberTokens))
            .withMessage("[ERROR] 음수는 입력할 수 없습니다.");

    }
}
