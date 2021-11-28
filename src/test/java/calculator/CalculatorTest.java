package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("숫자 하나만 문자열로 입력할 경우 해당 숫자를 반환한다")
    void shouldReturnIfSingleInput() {
        Calculator calculator = new Calculator("1");
        assertThat(calculator.sum()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 여러 개를 입력할 경우 쉼표를 구분자로 분리한다")
    void shouldSplitByComma() {
        Calculator calculator = new Calculator("1,2:3");
        assertThat(calculator.sum()).isEqualTo(6);
    }
}