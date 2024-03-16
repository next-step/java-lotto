package caculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("두인자의 값을 더한다")
    void plusMethodTest(){
        assertThat(calculator.plus(4,5)).isEqualTo(9);
    }

    @Test
    @DisplayName("두 인자의 값을 뺀다")
    void minus() {
        assertThat(calculator.minus(2,5)).isEqualTo(-3);
    }

    @Test
    @DisplayName("두 인자의 값을 나누고, 결과값은 정수여야한다.")
    void divide() {
        assertThat(calculator.divide(10,6)).isEqualTo(1);
        assertThat(calculator.divide(10,5)).isEqualTo(2);

    }

    @Test
    @DisplayName("두 연산자의 값을 곱한다.")
    void multiple() {

        assertThat(calculator.multiple(2,5)).isEqualTo(10);
    }
}
