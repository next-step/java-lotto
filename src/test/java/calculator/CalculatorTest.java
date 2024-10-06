package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("입력값이 숫자 하나일 경우 해당 숫자를 그대로 반환한다.")
    void test01() {
        final String userInput = "3";

        assertThat(Calculator.calculate(userInput)).isEqualTo(3);
    }
}
