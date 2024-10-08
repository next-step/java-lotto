package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionTest {

    @DisplayName("뺄셈을 할수 있다.")
    @Test
    void calculateTest() {
        Multiplication multiplication = new Multiplication();

        assertThat(multiplication.calculate(9, 2)).isEqualTo(7);
    }

    @DisplayName("'-' 연산자인 경우 true 반환한다.")
    @Test
    void supportsTest() {
        Multiplication multiplication = new Multiplication();

        assertThat(multiplication.supports("+")).isFalse();
        assertThat(multiplication.supports("-")).isTrue();
        assertThat(multiplication.supports("/")).isFalse();
        assertThat(multiplication.supports("*")).isFalse();
    }
}