package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class CalculatorTest {
    @DisplayName("기본 연산 테스트")
    @Test
    void calculate() {
        Calculator calculator = Calculator.of(List.of("1", "+", "2"));
        int result = calculator.calculate();
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("반복 연산 테스트")
    @Test
    void calculate2() {
        Calculator calculator = Calculator.of(List.of("3", "+", "4", "-", "1", "/", "2", "*", "3"));
        assertThat(calculator.calculate()).isEqualTo(9);
    }
}
