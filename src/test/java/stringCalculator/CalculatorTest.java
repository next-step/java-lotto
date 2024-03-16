package stringCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    @Test
    @DisplayName("덧셈")
    void addition_test() {
        assertThat(calculator.calculator("8 + 2")).isEqualTo(10);
    }

    @Test
    @DisplayName("뺄셈")
    void substraction_test() {
        assertThat(calculator.calculator("8 - 2")).isEqualTo(6);
    }

    @Test
    @DisplayName("곱셈")
    void multiplication_test() {
        assertThat(calculator.calculator("8 * 2")).isEqualTo(16);
    }
    @Test
    @DisplayName("나눗셈")
    void division_test() {
        assertThat(calculator.calculator("8 / 2")).isEqualTo(4);
    }

    @Test
    @DisplayName("나눗셈 결과는 정수여야함")
    void division_int_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                calculator.calculator("8 / 3"));
    }

    @Test
    @DisplayName("0으로 나눌수 없음")
    void division_by_zero_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                calculator.calculator("8 / 0"));
    }
}
