package Lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void 텍스트_숫자로_변환() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 덧셈_계산하기() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("1 + 2 + 3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 뺄셈_계산하기() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("10 - 2 - 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 곱셈_계산하기() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("10 * 2 * 3");
        assertThat(result).isEqualTo(60);
    }

    @Test
    void 나눗셈_계산하기() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("10 / 2 / 3");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 여러_연산자_계산하기() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("10 + 2 * 3 / 6 - 1");
        assertThat(result).isEqualTo(5);
    }
}
