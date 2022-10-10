package Lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void 덧셈_계산하기() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("1 + 2 + 3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 텍스트_숫자로_변환() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }
}
