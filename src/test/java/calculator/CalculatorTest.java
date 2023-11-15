package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.Calculator.calculate;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈 기능")
    void test1() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 기능")
    void test2() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(4, 2);

        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 기능")
    void test3() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(4, 2);

        assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("나눗셈 기능")
    void test4() {
        Calculator calculator = new Calculator();
        int result = calculator.division(10, 2);

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("나눗셈의 경우 결괏값이 정수가 아니면 IllegalArgumentException 발생한다.")
    void test5() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.division(10, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("빈 공백 문자일 경우 IllegalArgumentException 발생한다.")
    void test6(String value) {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.isNullOrEmpty(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("null일 경우 IllegalArgumentException 발생한다.")
    @NullAndEmptySource
    void test7(String value) {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.isNullOrEmpty(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산을 포함한 계산 기능")
    void test8() {
        int result = calculate("1 + 2 * 4 / 3");
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("사칙연산이 아닌 경우 IllegalArgumentException이 발생한다.")
    void test9() {
        assertThatThrownBy(() -> calculate("1 % 2 # 4 / 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
