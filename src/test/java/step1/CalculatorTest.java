package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("빈 문자 입력하면 exception")
    void nullValidation() {

        String inputFormula = null;
        assertThatThrownBy(() -> new Calculator(inputFormula))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 exception")
    void operatorValidation() {

        String inputFormula = "1 - 2 @ 3";
        assertThatThrownBy(() -> new Calculator(inputFormula))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산 테스트1")
    void calculatorTest1() {

        Calculator cal = new Calculator("1 + 2 + 3 - 1 - 2 * 2 / 2");
        cal.init();
        assertThat(cal.execute()).isEqualTo(3);
    }

    @Test
    @DisplayName("사칙연산 테스트2")
    void calculatorTest2() {

        Calculator cal = new Calculator("1 + 8 / 3 - 1 * 2");
        cal.init();
        assertThat(cal.execute()).isEqualTo(4);
    }
}
