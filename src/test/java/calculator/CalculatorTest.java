package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * 1. 숫자와 연산자를 입력받아 값을 계산한다.
 */
public class CalculatorTest {
    @Test
    void create() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate(2.0, "+", 3.0)).isEqualTo(5);
    }
}
