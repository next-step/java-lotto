package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    void plusTest() {

        Formula formula = new Formula("1 + 2 + 3");
        Calculator cal = new Calculator(formula);
        cal.init();
        assertThat(cal.execute()).isEqualTo(6);
    }

    @Test
    @DisplayName("덧셈 뺄셈 테스트")
    void plusMinusTest() {

        Formula formula = new Formula("1 + 2 - 3");
        Calculator cal = new Calculator(formula);
        cal.init();
        assertThat(cal.execute()).isEqualTo(0);
    }
}
