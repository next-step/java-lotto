package step1.calculator.controller;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorAppTest {

    @Test
    @DisplayName("CalculatorApp 테스트 #1 - 연산1번")
    void run() {
        // given
        String input = "2 + 3";

        // when
        CalculatorApp calculator = new CalculatorApp();
        int result = calculator.calculates(input);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("CalculatorApp 테스트 #2 - 연산3번")
    void run2() {
        // given
        String input = "2 + 3 * 4 / 2";

        // when
        CalculatorApp calculator = new CalculatorApp();
        int result = calculator.calculates(input);

        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("CalculatorApp 테스트 #3 - 음수연산")
    void run3() {
        // given
        String input = "-1 + -2 * -4 / -2";

        // when
        CalculatorApp calculator = new CalculatorApp();
        int result = calculator.calculates(input);

        // then
        assertThat(result).isEqualTo(-6);
    }



}
