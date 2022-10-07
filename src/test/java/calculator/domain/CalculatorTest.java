package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("덧셈 연산 테스트")
    void addTest() {
        assertThat(new Calculator(5, 3).add()).isEqualTo(8);
    }

    @Test
    @DisplayName("뺄셈 연산 테스트")
    void subtractTest() {
        assertThat(new Calculator(5, 3).subtract()).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 연산 테스트")
    void multiplyTest() {
        assertThat(new Calculator(5, 3).multiply()).isEqualTo(15);
    }

    @Test
    @DisplayName("나눗셈 연산 테스트")
    void divideTest() {
        assertThat(new Calculator(20, 3).divide()).isEqualTo(6);
    }
}
