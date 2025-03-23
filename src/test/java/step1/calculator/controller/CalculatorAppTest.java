package step1.calculator.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorAppTest {

    @Test
    @DisplayName("CalculatorApp 테스트 #1")
    void run() {
        // given
        String input = "2 + 3";

        // when
        CalculatorApp calculator = new CalculatorApp();
        int result = calculator.calculates(input.split(" "));

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("CalculatorApp 테스트 #2")
    void run2() {
        // given
        String input = "2 + 3 * 4 / 2";

        // when
        CalculatorApp calculator = new CalculatorApp();
        int result = calculator.calculates(input.split(" "));

        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("CalculatorApp 테스트 #3")
    void run3() {
        // given
        String input = "-1 + -2 * -4 / -2";

        // when
        CalculatorApp calculator = new CalculatorApp();
        int result = calculator.calculates(input.split(" "));

        // then
        assertThat(result).isEqualTo(-6);
    }

}
