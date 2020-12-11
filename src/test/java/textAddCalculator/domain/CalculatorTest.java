package textAddCalculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void Setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("null 또는 빈문자 계산")
    public void splitAndSum_nullOrEmpty() {
        int result = calculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = calculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자하나 계산")
    public void splitAndSumOneNumber() throws Exception { ;
        int result = calculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자 test")
    public void splitAndSumCommaDelimiter() throws Exception {
        int result = calculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 or 콜론 구분자 test")
    public void splitAndSumCommaColonDelimiter() throws Exception {
        int result = calculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("custom 구분자 test")
    public void splitAndSumCustomDelimiter() throws Exception {
        int result = calculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 입력 test")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> calculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
