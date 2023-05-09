package calculator.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1. 숫자와 연산자를 입력받아 값을 계산한다.
 */
public class CalculatorTest {
    @Test
    void create() {
        assertThat(Calculator.calculate(new Operand(3.0), new Operator("+"), new Operand(5.0)))
                .isEqualTo(new Operand(8.0));
    }
}
