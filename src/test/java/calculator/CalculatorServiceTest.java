package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {
    @Test
    @DisplayName("덧셈")
    void plus() {
        Operand left = new Operand(10);
        Operand right = new Operand(20);

        CalculatorService calculatorService = new CalculatorService();
        Operand result = calculatorService.calculator(new Operator("+"), left, right);

        assertThat(result).isEqualTo(new Operand(30));
    }

    @Test
    @DisplayName("문자열 나누기 null 체크")
    void split_null_체크() {
        String input = "";
        CalculatorService calculatorService = new CalculatorService();

        assertThatThrownBy(() ->  calculatorService.split(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값이 비어있습니다");
    }
    @Test
    @DisplayName("문자열 나누기 성공")
    void split_성공() {
        String input = "2 + 3 * 4 / 2";
        CalculatorService calculatorService = new CalculatorService();

        List<String> result = calculatorService.split(input);

        assertThat(result).isEqualTo(List.of("2", "+", "3", "*", "4", "/", "2"));

    }
}