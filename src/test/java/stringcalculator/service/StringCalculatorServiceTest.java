package stringcalculator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorServiceTest {

    @Test
    @DisplayName("2 + 3 * 4 / 2")
    void calculate_expression_1() {
        //given
        String expression = "2 + 3 * 4 / 2";
        //when
        StringCalculatorService service = new StringCalculatorService();
        //then
        Assertions.assertThat(service.calculate(expression.split(" "))).isEqualTo(10);

    }

    @Test
    @DisplayName("-2 + 3 * 4 / 3")
    void calculate_expression_2() {
        //given
        String expression = "-2 + 3 * 4 / 3";
        //when
        StringCalculatorService service = new StringCalculatorService();
        //then
        Assertions.assertThat(service.calculate(expression.split(" "))).isEqualTo(1);

    }

}