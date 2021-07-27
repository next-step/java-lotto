package calculator;

import calculator.exception.NotNaturalNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    private final StringAddCalculator calculator = StringAddCalculator.getInstance();

    @Test
    @DisplayName("null 또는 빈 문자열이 입력되면 0을 반환한다")
    public void validateNullOrEmpty() {
        int result = calculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = calculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나만 입력되면 해당 숫자를 반환한다")
    public void naturalNumberOne() throws Exception {
        int result = calculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자로 문자열을 분리하여 합산 반환한다")
    public void defaultDelimV1() throws Exception {
        int result = calculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표와 콜론으로 문자열을 분리하여 합산 반환한다")
    public void defaultDelimV2() throws Exception {
        int result = calculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 있을 경우 커스텀 구분자로 문자열을 분리하여 합산 반환한다")
    public void customDelim() throws Exception {
        int result = calculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 입력될 경우 RuntimeException을 반환한다")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> calculator.splitAndSum("-1,2,3"))
                .isInstanceOf(NotNaturalNumberException.class)
                .hasMessage("Not a natural number.");
    }
}
