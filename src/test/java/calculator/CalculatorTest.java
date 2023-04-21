package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("계산기를 생성한다.")
    void test01() {
        Calculator calculator = new Calculator();

        assertThat(calculator).isNotNull();
    }
    
    @Test
    @DisplayName("덧셈 계산")
    void test02() {
        Calculator calculator = new Calculator();

        int result = calculator.calculate("1 + 2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("곱셈 계산")
    void test03() {
        Calculator calculator = new Calculator();

        int result = calculator.calculate("1 * 2");

        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 계산")
    void test04() {
        Calculator calculator = new Calculator();

        int result = calculator.calculate("3 / 2");

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈 계산")
    void test05() {
        Calculator calculator = new Calculator();

        int result = calculator.calculate("3 * 2");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("여러 연산자 섞인 계산")
    void test06() {
        Calculator calculator = new Calculator();

        int result = calculator.calculate("2 + 3 * 4 / 2");

        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest(name = "빈 값이나 공백이 들어오면 에러 발생")
    @ValueSource(strings = {"", " "})
    void test98() {
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.calculate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null 이 들어오면 에러 발생")
    void test99() {
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.calculate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
