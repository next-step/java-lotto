package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringCalculatorTest {

    @Test
    @DisplayName("문자열 계산 테스트")
    void customDelimiterCalculatorTest() {
        StringCalculator calculator = new StringCalculator();
        assertThat(calculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열 계산 테스트")
    void normalDelimiterCalculatorTest() {
        StringCalculator calculator = new StringCalculator();
        assertThat(calculator.calculate("1,2:3")).isEqualTo(6);
    }
}
