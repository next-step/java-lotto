package stringpluscalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void 생성() {
        Calculator calculator = Calculator.of("1,2,3");
        assertThat(calculator).isEqualTo(Calculator.of("1,2,3"));
    }

    @Test
    void 빈문자열입력() {
        Calculator calculator = Calculator.of("");
        int result = calculator.sum();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 기본구분자입력() {
        Calculator calculator = Calculator.of("1,2:3");
        int result = calculator.sum();
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀구분자입력() {
        Calculator calculator = Calculator.of("//;\n1;2;3");
        int result = calculator.sum();
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 음수입력_예외발생() {
        assertThatThrownBy(() -> {
            Calculator.of("-1,1");
        }).isInstanceOf(RuntimeException.class);
    }
}
