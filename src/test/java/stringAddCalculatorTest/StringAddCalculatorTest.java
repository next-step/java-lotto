package stringAddCalculatorTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringAddCalculator.StringAddCalculator;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    
    @Test
    @DisplayName("null 또는 빈 문자")
    public void nullOrEmpty() {
        int result = StringAddCalculator.sumString(null);
        assertThat(result).isEqualTo(0);
        result = StringAddCalculator.sumString("");
        assertThat(result).isEqualTo(0);
    }
    
    @ParameterizedTest
    @ValueSource(strings = "1")
    @DisplayName("숫자 하나만 넣었을 때")
    public void onlyNumber(String input) {
        assertThat(StringAddCalculator.sumString(input)).isEqualTo(1);
    }
    
    @ParameterizedTest
    @ValueSource(strings = "1,2")
    @DisplayName("쉼표 구분자")
    public void commaDelimiter(String input) {
        assertThat(StringAddCalculator.sumString(input)).isEqualTo(3);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "//;\n1;2;3"})
    @DisplayName("쉼표 및 커스텀 구분자")
    public void commaAndCustomDelimiter(String input) {
        assertThat(StringAddCalculator.sumString(input)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = "-1,2,3")
    @DisplayName("음수 입력시")
    public void negativeNumber(String input) {
        assertThatThrownBy(() -> StringAddCalculator.sumString(input))
                .isInstanceOf(RuntimeException.class);
    }
}