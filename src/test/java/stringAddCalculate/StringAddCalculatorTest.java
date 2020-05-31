package stringAddCalculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null or 빈문자 체크")
    public void isNullOrEmpty(String expression) {
        int result = StringAddCalculator.add(expression);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("숫자가 하나일 경우")
    public void countOne(String expression) throws Exception {
        int result = StringAddCalculator.add(expression);
        assertThat(result).isEqualTo(Integer.parseInt(expression));
    }

    @Test
    @DisplayName("쉼표 구분자")
    public void commaDelimiter() throws Exception {
        int result = StringAddCalculator.add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 또는 콜론 구분자")
    public void commaOrColonDelimiter() throws Exception {
        int result = StringAddCalculator.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("User가 만든 구분자")
    public void customDelimiter() throws Exception {
        int result = StringAddCalculator.add("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 예외 처리")
    public void negativeException() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.add("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
