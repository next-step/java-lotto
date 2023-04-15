package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    @DisplayName("사칙연산 입력 받아서 계산 테스트")
    void calculate() {
        // given
        Calculator calculator = new Calculator();
        String input = "2 + 3 * 4 / 2";
        int expected = 10;

        // when
        calculator.insert(input);
        int actual = calculator.calculate();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사칙연산 입력 받아서 계산 테스트 (입력값 예외)")
    void calculateException() {
        // given
        Calculator calculator = new Calculator();
        String input = "2 + 3 * 4 / 2 +";

        // then
        assertThatThrownBy(() -> calculator.insert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값과 연산자의 수가 맞지 않습니다.");
    }

}
