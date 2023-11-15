package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
